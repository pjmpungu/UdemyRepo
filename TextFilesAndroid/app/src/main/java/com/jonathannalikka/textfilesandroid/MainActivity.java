package com.jonathannalikka.textfilesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etName, etSurname;
    TextView tvResults;
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);

        tvResults = (TextView) findViewById(R.id.tvResults);

        persons = new ArrayList<Person>();

        loadData();

    }

    public void btnAddData(View v){
        String name = etName.getText().toString().trim();
        String surname = etSurname.getText().toString().trim();

        Person person = new Person(name, surname);
        persons.add(person);

        setTextToTextView();
    }

    private void setTextToTextView() {
        String text = "";

        for(int k=0; k < persons.size(); k++){
            text = text + persons.get(k).getName() + " " + persons.get(k).getSurname() + "\n";
        }

        tvResults.setText(text);
    }

    public void loadData(){

        persons.clear();
        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;

        if(file.exists()){
            try {

                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));

                while((lineFromFile=reader.readLine()) !=null){
                    StringTokenizer tokens = new StringTokenizer(lineFromFile, ",");
                    Person person = new Person(tokens.nextToken(), tokens.nextToken());

                    persons.add(person);
                }

                reader.close();
                setTextToTextView();

            }catch (IOException e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void btnSaveData (View v){

        try {

            FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for(int k =0; k < persons.size(); k++){
                outputFile.write( persons.get(k).getName() + "," + persons.get(k).getSurname() + "\n");
            }

            outputFile.flush();
            outputFile.close();

        }catch (IOException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}