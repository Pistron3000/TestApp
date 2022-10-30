package com.example.testapp;
//Что то добавил для теста

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText number_field_1, number_field_2;
    private Button add_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        number_field_1 = findViewById(R.id.number_field_1);
        number_field_2 = findViewById(R.id.number_field_2);
        add_button = findViewById(R.id.add_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(number_field_1.getText().toString());
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                float res = num1 + num2;
                resultTextView.setText(String.valueOf(res));
            }
        });
    }

    public void  startNewActivity2(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }

    public void  startNewActivity(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}