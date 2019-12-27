package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout layoutUsername, layoutPassw;
    TextInputEditText editTextUsername, editTextPassw;
    Button btnLogin;
    TextView txtViewRegister;

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
                    userLogin();
                }
                break;
            case R.id.textview_register:
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userLogin() {
        Intent intent = new Intent(MainActivity.this, AllToDoActivity.class);
        startActivity(intent);
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
