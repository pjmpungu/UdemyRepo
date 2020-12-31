package com.jonathannalikka.intentspractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    ImageView ivSmile;
    ImageView ivStraight;
    ImageView ivFrown;

    EditText etName;
    EditText etPhoneNumber;
    EditText etWebsite;
    EditText etLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //setting up image views and edit text views

        ivSmile=findViewById(R.id.ivSmile);
        ivStraight=findViewById(R.id.ivStraight);
        ivFrown=findViewById(R.id.ivFrown);

        etName=findViewById(R.id.etName);
        etPhoneNumber=findViewById(R.id.etPhoneNumber);
        etWebsite=findViewById(R.id.etWebsite);
        etLocation=findViewById(R.id.etLocation);
        //on click listeners for images
        ivSmile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClicked(1);
            }
        });
        ivStraight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClicked(2);
            }
        });
        ivFrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClicked(3);
            }
        });
    }
    //one method that runs for all buttons when they're clicked to use less code
    public void imageClicked(int imageView){
        //get text from all buttons
        String name=etName.getText().toString().trim();
        String phoneNum=etPhoneNumber.getText().toString().trim();
        String website=etWebsite.getText().toString().trim();
        String address=etLocation.getText().toString().trim();

        //check if strings are empty, otherwise close this activity and send intent
        if(name.isEmpty()||phoneNum.isEmpty()||website.isEmpty()||address.isEmpty()){
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent= new Intent();
            intent.putExtra("name", name);
            intent.putExtra("phone number",phoneNum);
            intent.putExtra("website",website);
            intent.putExtra("address", address);
            intent.putExtra("image",imageView);
            setResult(RESULT_OK,intent);
            Activity2.this.finish();
        }

    }

}