package com.example.mytodo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytodo.http_helper.User;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtViewLogin;
    TextInputEditText editName, editUsername, editPassw, editConfPassw;
    Button btnRegister;

    String strFullName, strUsername, strPassw, strConfPassw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtViewLogin = (TextView) findViewById(R.id.textview_register);
        editName = (TextInputEditText) findViewById(R.id.edittext_fullname);
        editUsername = (TextInputEditText) findViewById(R.id.edittext_username1);
        editPassw = (TextInputEditText) findViewById(R.id.edittext_passw);
        editConfPassw = (TextInputEditText) findViewById(R.id.edittext_confpassw);
        btnRegister = (Button) findViewById(R.id.button_register);


        txtViewLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.textview_register:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button_register:
                strFullName = editName.getText().toString().trim();
                strUsername = editUsername.getText().toString().trim();
                strPassw = editPassw.getText().toString().trim();
                strConfPassw = editConfPassw.getText().toString().trim();

                try {
                    registerUsers(strFullName, strUsername, strPassw, strConfPassw);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void registerUsers(String strFullName, String strUsername, String strPassw, String strConfPassw) throws IOException, JSONException {

        User resp = new User();
        String json = resp.registerPayload(strFullName, strUsername, strPassw, strConfPassw);
        Log.d("JSON-BODY", json);
        Log.d("REQUEST-URL", Constant.USER_REGISTER_API_URL);

//        Toast.makeText(this, json, Toast.LENGTH_LONG).show();
        resp.registerUser(Constant.USER_REGISTER_API_URL, json, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String responseStr = response.body().string();
                    Log.i("REGISTER_RESP", responseStr);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, responseStr, Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    Log.e("REQ", response.body().string());
                }
            }
        });
//        String response = resp.registerUser(Constant.USER_REGISTER_API_URL, json);
//
//        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}
