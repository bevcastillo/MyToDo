package com.example.mytodo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mytodo.CustomAdapter.ToDoListAdapter;
import com.example.mytodo.Objects.ToDoObj;
import com.example.mytodo.Objects.ToDoObjList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AllToDoActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab_add;
    RecyclerView recyclerViewList;

    List<ToDoObjList> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_to_do);

        fab_add = (FloatingActionButton) findViewById(R.id.fab_add_to_do);
        recyclerViewList = (RecyclerView) findViewById(R.id.recyclerview);

        fab_add.setOnClickListener(this);

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
        recyclerViewList.setLayoutManager(layoutManager);
        recyclerViewList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewList.setItemAnimator(new DefaultItemAnimator());

        recyclerViewList.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.fab_add_to_do:
//                showAddTodoLayout();
                Intent intent = new Intent(AllToDoActivity.this, AddToDoActivity.class);
                startActivity(intent);
                break;
        }
    }

//    private void showAddTodoLayout() {
//        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = this.getLayoutInflater();
//        final View dialogView = inflater.inflate(R.layout.custom_add_to_do, null);
//        builder.setView(dialogView);
//
//
//
//        builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                ToDoObj toDoObj = new ToDoObj();
////                toDoObj.setToDoTitle();
//            }
//        });
//
//        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        AlertDialog alertDialog = builder.create();
//        alertDialog.show();
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_profile:
                Intent intent = new Intent(AllToDoActivity.this, UserProfileActivity.class);
                startActivity(intent);
                return true;
            case R.id.other_profiles:
                Intent intent1 = new Intent(AllToDoActivity.this, OtherProfilesActivity.class);
                startActivity(intent1);
                return true;
            case R.id.menu_settings:
                Toast.makeText(this, "You have clicked settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout:
                logoutUser();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void logoutUser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(AllToDoActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(AllToDoActivity.this, "You have been logged out.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create();
        builder.show();
    }
}
