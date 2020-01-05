package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddToDoActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtTodoCreated, txtToDoUpdated;
    EditText editTextTodoTitle;
    Button btnAdd, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        txtTodoCreated = (TextView) findViewById(R.id.txtview_dateCreated);
        txtToDoUpdated = (TextView) findViewById(R.id.txtview_dateUdpated);
        editTextTodoTitle = (EditText) findViewById(R.id.edittext_todo_title);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        btnAdd = (Button) findViewById(R.id.btn_add);

        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.btn_add:
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_delete:
                break;
        }
    }
}
