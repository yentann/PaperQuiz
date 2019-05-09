package com.example.paperquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    EditText studentName;
    EditText studentGPA;
    Button btninsert;
    Button btnretrieve;
    TextView studentinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentName = findViewById(R.id.editTextName);
        studentGPA = findViewById(R.id.editTextGPA);
        btninsert = findViewById(R.id.buttonInsert);
        btnretrieve = findViewById(R.id.buttonRetrieve);
        studentinfo = findViewById(R.id.Result);


        btninsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask(studentName.getText().toString(), studentGPA.getText().toString());
                db.close();
            }
        });

        btnretrieve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> data = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                //Debug using Logcat
                Log.d("Database Content", i +". "+data.get(i));
                 txt += i + ". " + data.get(i).getName() + data.get(i).getGPA() + "\n";
                }
                  studentinfo.setText(txt);




            }
        });


    }
}
