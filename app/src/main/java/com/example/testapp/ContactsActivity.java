package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsActivity extends AppCompatActivity {

    private String[] namesArr = new String[] {"Josh", "John", "George", "Bob", "Alex"};
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.name_item, R.id.user_name, namesArr);
        listView.setAdapter(adapter);
    }

    public void goHome(View view){
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }
    public void goContacts(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
}