package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TestRecycleView extends AppCompatActivity {

    private ArrayList<User> usersList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_recycle_view);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();


        //void recyclerView: RecyclerView = findViewById(R.id.rec)
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        usersList.add(new User("John"));
        usersList.add(new User("Bob"));
        usersList.add(new User("Alex"));
    }
}

