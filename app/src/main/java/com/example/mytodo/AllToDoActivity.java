package com.example.mytodo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AllToDoActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab_add;
    RecyclerView recyclerViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_to_do);

        fab_add = (FloatingActionButton) findViewById(R.id.fab_add_to_do);
        recyclerViewList = (RecyclerView) findViewById(R.id.recyclerview);

        fab_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.fab_add_to_do:
                showAddTodoLayout();
                break;
        }
    }

    private void showAddTodoLayout() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_add_to_do, null);
        builder.setView(dialogView);
        builder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

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
                Toast.makeText(this, "You have clicked profile", Toast.LENGTH_SHORT).show();
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
