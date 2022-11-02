package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FourthActivity extends AppCompatActivity {

    private EditText user_name_field, text_something;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        user_name_field = findViewById(R.id.user_name_field);
        text_something = findViewById(R.id.text_something);
    }

    public void saveDate(View view){

        String user_name = user_name_field.getText().toString();
        String text_someth = text_something.getText().toString();
        try {
            FileOutputStream fileOutput = openFileOutput("user_data.txt", MODE_PRIVATE);
            fileOutput.write((user_name + ". " + text_someth).getBytes());
            fileOutput.close();

            user_name_field.setText("");
            text_something.setText("");
            Toast.makeText(this, "Текст сохранен", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Не можем обработать файл", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getDate(View view){

        try {
            FileInputStream fileInput = openFileInput("user_data.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader bR = new BufferedReader(reader);

            StringBuilder stringBuilder = new StringBuilder();
            String lines = "";
            while((lines = bR.readLine()) != null) {
                stringBuilder.append(lines).append("\n");
            }
            Toast.makeText(this, stringBuilder, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void goContacts(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
    public void goHome(View view){
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void goTestRecycle(View view){
        Intent intent = new Intent(this, TestRecycleView.class);
        startActivity(intent);
    }
}