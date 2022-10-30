package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity {

    private ImageButton button_car1, button_car2;
    private MediaPlayer carSound1, carSound2;
    private Button button_stop_play;
    private Button button_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button_car1 = findViewById(R.id.button_car1);
        button_car2 = findViewById(R.id.button_car2);
        button_stop_play = findViewById(R.id.button_stop_play);
        button_back = findViewById(R.id.button_back);


        carSound1 = MediaPlayer.create(this, R.raw.car);
        carSound2 = MediaPlayer.create(this, R.raw.police);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayButton(carSound1, carSound2);
                goBack();
            }
        });

        button_stop_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlayButton(carSound2, carSound1);
            }
        });

        button_car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayButton(carSound1, carSound2);

            }
        });

        button_car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayButton(carSound2, carSound1);

            }
        });
    }

    private void goBack() {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }

    private void stopPlayButton(MediaPlayer sound1, MediaPlayer sound2) {
        if(sound1.isPlaying()){
            sound1.pause();
            sound1.seekTo(0);
            sound1.setLooping(false);
        }
        if(sound2.isPlaying()){
            sound2.pause();
            sound2.seekTo(0);
            sound2.setLooping(false);
        }
    }


//    public void goBack(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

   // private void stopSound(MediaPlayer)


    private void soundPlayButton(MediaPlayer sound1, MediaPlayer sound2) {
        if (sound1.isPlaying()){
            sound1.pause();
            sound1.seekTo(0);
            sound1.setLooping(false);
        }

        if (sound2.isPlaying()){
            sound2.pause();
            sound2.seekTo(0);
            sound2.setLooping(false);
        }

        sound1.start();
        sound1.setLooping(true);
    }
}