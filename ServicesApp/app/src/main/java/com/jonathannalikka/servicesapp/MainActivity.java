package com.jonathannalikka.servicesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView ivPlayStop;
    String audioLink = "https://drive.google.com/file/d/1vS-33eEjizmaTA9edN-L0ESPhrm9TpWQ/view";

    boolean musicPlaying = false;
    Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivPlayStop = findViewById(R.id.ivPlayStop);
        ivPlayStop.setImageResource(R.drawable.play);

        serviceIntent = new Intent(this, MyPlayService.class);

        ivPlayStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!musicPlaying){
                    
                    playAudio();
                    ivPlayStop.setImageResource(R.drawable.stop);
                    musicPlaying = true;
                }else {
                    
                    stopPlayService();
                    ivPlayStop.setImageResource(R.drawable.play);
                    musicPlaying = false;
                }
            }
        });
    }

    private void playAudio() {

        serviceIntent.putExtra("AudioLink", audioLink);

        try{

            startService(serviceIntent);

        }catch (SecurityException e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void stopPlayService(){

        try{

            stopService(serviceIntent);

        }catch (SecurityException e){

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}