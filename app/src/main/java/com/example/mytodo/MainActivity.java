package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytodo.http_helper.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout layoutUsername, layoutPassw;
    TextInputEditText editTextUsername, editTextPassw;
    Button btnLogin;
    TextView txtViewRegister;

    String strUsername, strPassw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutUsername = (TextInputLayout) findViewById(R.id.textInputLayout);
        editTextUsername = (TextInputEditText) findViewById(R.id.edittext_username);
        layoutPassw = (TextInputLayout) findViewById(R.id.textInputLayout2);
        editTextPassw = (TextInputEditText) findViewById(R.id.edittext_password);
        btnLogin = (Button) findViewById(R.id.button_login);
        txtViewRegister = (TextView) findViewById(R.id.textview_register);

        txtViewRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.button_login:
                if (checkEmptyFields()){

                    strUsername = editTextUsername.getText().toString().trim();
                    strPassw = editTextPassw.getText().toString().trim();

                    try {
                        userLogin(strUsername, strPassw);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.textview_register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userLogin(String username, String passw) throws JSONException {
//        Intent intent = new Intent(MainActivity.this, AllToDoActivity.class);
//        startActivity(intent);
//        Toast.makeText(this, "Successfully logged in.", Toast.LENGTH_SHORT).show();

        User resp = new User();
        String json = resp.loginPayload(username, passw);
        resp.loginUser(Constant.USER_LOGIN_API_URL, json, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String responseStr = response.body().string();
                    Log.i("LOGIN_RESP", responseStr);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, responseStr, Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Log.e("REQ", response.body().string());
                }
            }
        });

    }



    private boolean checkEmptyFields() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassw.getText().toString();
        boolean ok = true;

        if (username.isEmpty()){
            layoutUsername.setError("Username can not be empty.");
            ok = false;
        }

        if (password.isEmpty()){
            layoutPassw.setError("Password can not be empty.");
            ok = false;
        }

        return ok;
    }
}
