package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class ThirdActivity extends AppCompatActivity {

    private Button button_fragment1, button_fragment2;
    private FirstFragment firstFragment = new FirstFragment();

    //private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        button_fragment1 = findViewById(R.id.button_fragment1);
        button_fragment2 = findViewById(R.id.button_fragment2);
        //frameLayout = findViewById(R.id.frame_layout);

        setNewFragment(firstFragment);



//        FirstFragment firstFragment = new FirstFragment();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.frame_layout, firstFragment);

        button_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNewFragment(firstFragment);
            }
        });

        button_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                setNewFragment(secondFragment);
            }
        });
    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

}