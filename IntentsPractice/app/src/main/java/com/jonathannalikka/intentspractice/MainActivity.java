package com.jonathannalikka.intentspractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivFace, ivPhone, ivWeb, ivMap;
    Button btnCreate;
    //constant for requestcode
    final int ACTIVITY2=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up image views and hiding image views on create
        ivFace=findViewById(R.id.ivFace);
        ivFace.setVisibility(View.GONE);

        ivPhone=findViewById(R.id.ivPhone);
        ivPhone.setVisibility(View.GONE);

        ivWeb=findViewById(R.id.ivWeb);
        ivWeb.setVisibility(View.GONE);

        ivMap=findViewById(R.id.ivMap);
        ivMap.setVisibility(View.GONE);
        btnCreate=findViewById(R.id.btnCreate);
        //set up click listener for button
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,
                        com.jonathannalikka.intentspractice.Activity2.class);
                startActivityForResult(intent, ACTIVITY2);
            }
        });
    }
    //overriding method once receiving result, images are visible, setting up click methods for them
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==ACTIVITY2) {
                ivFace.setVisibility(View.VISIBLE);
                //change smileyface image based on result from intent
                if(data.getIntExtra("image",1)==1){
                    ivFace.setImageResource(R.drawable.smile_face);
                }else if(data.getIntExtra("image",1)==2){
                    ivFace.setImageResource(R.drawable.straight_face);
                }else{
                    ivFace.setImageResource(R.drawable.frown_face);
                }
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);
                final String num=data.getStringExtra("phone number");
                final String website=data.getStringExtra("website");
                final String address=data.getStringExtra("address");
                //now set up the on click listeners
                ivPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                        startActivity(intent);
                    }
                });

                ivWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                        startActivity(intent);
                    }
                });
                ivMap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
                        startActivity(intent);
                    }
                });
            }
        }
    }
}