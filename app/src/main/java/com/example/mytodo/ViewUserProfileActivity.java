package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mytodo.CustomAdapter.ToDoListAdapter;
import com.example.mytodo.CustomAdapter.UserProfilesAdapter;
import com.example.mytodo.Objects.ToDoObjList;
import com.example.mytodo.Objects.UserObj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ViewUserProfileActivity extends AppCompatActivity {

    TextView txtName, txtUsername;
    RecyclerView recyclerViewUserToDo;

    String strName, strUsername;

    List<ToDoObjList> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_profile);

        txtName = (TextView) findViewById(R.id.textview_user_name);
        txtUsername = (TextView) findViewById(R.id.textview_user_email);
        recyclerViewUserToDo = (RecyclerView) findViewById(R.id.recyclerview_user_to_do);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle!=null){
            strName = bundle.getString("user_name");
            strUsername = bundle.getString("user_uname");

            setTitle(strName);
            txtName.setText(strName);
            txtUsername.setText(strUsername);
        }


        String currDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        list = new ArrayList<>();

        list.add(
                new ToDoObjList(
                        "Laba", 1, true, currDate,"",""
                )
        );

        list.add(
                new ToDoObjList(
                        "Luto", 1, true, currDate,"",""
                )
        );

        list.add(
                new ToDoObjList(
                        "Hugas plato", 1, false, currDate,"",""
                )
        );

        list.add(
                new ToDoObjList(
                        "Laag", 1, false, currDate,"",""
                )
        );

        ToDoListAdapter adapter = new ToDoListAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUserToDo.setLayoutManager(layoutManager);
        recyclerViewUserToDo.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewUserToDo.setItemAnimator(new DefaultItemAnimator());

        recyclerViewUserToDo.setAdapter(adapter);
    }
}
