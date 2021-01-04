package com.jonathannalikka.fragmentschallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {

    TextView tvModel, tvOwner, tvTel;
    ImageView ivMake;
    Button btnCarInfo, btnOwnerInfo;
    LinearLayout ownerInfo, carInfo;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting up instance variables

        tvModel = findViewById(R.id.tvModel);
        tvOwner = findViewById(R.id.tvOwner);
        tvTel = findViewById(R.id.tvTel);

        ivMake = findViewById(R.id.ivMake);

        btnCarInfo = findViewById(R.id.btnCarInfo);
        btnOwnerInfo = findViewById(R.id.btnOwnerInfo);

        fragmentManager= this.getSupportFragmentManager();
        ownerInfo = (LinearLayout) findViewById(R.id.ownerInfoFrag);
        carInfo = (LinearLayout) findViewById(R.id.carInfoFrag);

        ownerInfo.setVisibility(View.GONE);
        carInfo.setVisibility(View.VISIBLE);

        //set up click listeners for buttons to make fragments visible and invisble when clicked
        btnOwnerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ownerInfo.setVisibility(View.VISIBLE);
                carInfo.setVisibility(View.GONE);
            }
        });

        btnCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ownerInfo.setVisibility(View.GONE);
                carInfo.setVisibility(View.VISIBLE);
            }
        });

        onItemClicked(0);

    }

    //overriding interface from CarAdapter class to change text on car/owner info fragments when clicked
    @Override
    public void onItemClicked(int index) {
        tvModel.setText(ApplicationClass.cars.get(index).getModel());
        tvOwner.setText(ApplicationClass.cars.get(index).getOwner());
        tvTel.setText(ApplicationClass.cars.get(index).getTelNum());

        String make = ApplicationClass.cars.get(index).getMake();
        if (make.equals("mercedes")){
            ivMake.setImageResource(R.drawable.mercedes);
        }else if (make.equals("nissan")){
            ivMake.setImageResource(R.drawable.nissan);
        }else if (make.equals("volkswagen")){
            ivMake.setImageResource(R.drawable.volkswagen);
        }
    }
}