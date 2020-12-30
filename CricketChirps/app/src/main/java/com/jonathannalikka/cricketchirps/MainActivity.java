package com.jonathannalikka.cricketchirps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etChirps;
    Button btnCalc;
    TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set up instance vars
        etChirps=findViewById(R.id.etChirps);
        btnCalc=findViewById(R.id.btnCalc);
        tvAnswer=findViewById(R.id.tvAnswer);

        //set up click listener
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double numChirps=Double.parseDouble(etChirps.getText().toString());
                double temp= (numChirps/3.0)+4.0;
                String text= getString(R.string.temp_outside_is)+getString(R.string.new_line)+temp +getString(R.string.degrees_celsius);
                tvAnswer.setText(text);
            }
        });
    }
}