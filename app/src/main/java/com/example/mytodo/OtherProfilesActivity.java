package com.example.mytodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mytodo.CustomAdapter.UserProfilesAdapter;
import com.example.mytodo.Objects.UserObj;

import java.util.ArrayList;
import java.util.List;

public class OtherProfilesActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllProf;

    List<UserObj> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_profiles);

        recyclerViewAllProf = (RecyclerView) findViewById(R.id.recyclerview_all_profiles);

        list = new ArrayList<>();

        list.add(
                new UserObj(
                      1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        list.add(
                new UserObj(
                        1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        list.add(
                new UserObj(
                        1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        list.add(
                new UserObj(
                        1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        list.add(
                new UserObj(
                        1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        list.add(
                new UserObj(
                        1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        list.add(
                new UserObj(
                        1, "Richard Orofeo","rbo",""
                )
        );

        list.add(
                new UserObj(
                        1, "Beverly Castillo","bevcastillo",""
                )
        );

        list.add(
                new UserObj(
                        1, "John Doe","jdoe",""
                )
        );

        UserProfilesAdapter adapter = new UserProfilesAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewAllProf.setLayoutManager(layoutManager);
        recyclerViewAllProf.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewAllProf.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewAllProf.setItemAnimator(new DefaultItemAnimator());

        recyclerViewAllProf.setAdapter(adapter);
    }
}
