package com.jonathannalikka.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etCell = findViewById(R.id.etCell);
    }

    public void btnSubmit(View v){
        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();

            ContactsDB db = new ContactsDB(this);
            db.open();
            db.createEntry(name, cell);
            db.close();
            Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etCell.setText("");
    }

    public void btnShowData(View v){
        startActivity(new Intent(MainActivity.this, Data.class));
    }

    public void btnEditData(View v){
        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();

        ContactsDB db = new ContactsDB(this);
        db.open();
        db.updateEntry("1", name, cell);
        db.close();
        Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
        etName.setText("");
        etCell.setText("");
    }

    public void btnDeleteData(View v){

        ContactsDB db = new ContactsDB(this);
        db.open();
        db.deleteEntry("1");
        db.close();
        Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();

    }
}