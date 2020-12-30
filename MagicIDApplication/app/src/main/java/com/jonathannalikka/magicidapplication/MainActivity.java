package com.jonathannalikka.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up instance variables
        etID=findViewById(R.id.etID);
        btnSubmit=findViewById(R.id.btnSubmit);
        tvResult=findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        //setting up click listener
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String holds all text
                String idNumber=etID.getText().toString().trim();
                String dob=idNumber.substring(0,6);
                //integer to find gender of person
                int gender=Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if(gender<5)
                    sGender=getString(R.string.female);
                else
                    sGender=getString(R.string.male);

                int nationality=Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if(nationality==0)
                    sNationality=getString(R.string.citizen);
                else
                    sNationality=getString(R.string.resident);
                String text=getString(R.string.dob)+ dob + getString(R.string.newline) +
                        getString(R.string.gender)+ sGender+ getString(R.string.newline)+
                        getString(R.string.nationality)+ sNationality;

                tvResult.setText(text);

            }
        });
    }
}