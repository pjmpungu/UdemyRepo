package com.jonathannalikka.co;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle event", "In onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle event", "In onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle event", "In onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle event", "In onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle event", "In onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle event", "In onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle event", "In onRestart");
    }
}