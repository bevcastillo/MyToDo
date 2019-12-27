package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txtViewLogin = (TextView) findViewById(R.id.textview_register);

        txtViewLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.textview_register:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
