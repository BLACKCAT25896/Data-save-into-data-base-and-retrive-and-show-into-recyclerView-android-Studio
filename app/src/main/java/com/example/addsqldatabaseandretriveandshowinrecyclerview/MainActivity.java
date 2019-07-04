package com.example.addsqldatabaseandretriveandshowinrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name, age;
    private Button insert, showData;
    private String aName, aAge;
    private DatabaseOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aName = name.getText().toString();
                aAge = age.getText().toString();
                long id = helper.insertData(aName,aAge);

                Toast.makeText(MainActivity.this, "id = " + id , Toast.LENGTH_SHORT).show();


            }
        });

        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ShowDataActivity.class));
            }
        });





    }

    private void init() {
        name = findViewById(R.id.nameET);
        age = findViewById(R.id.ageET);
        insert = findViewById(R.id.insertBtn);
        showData = findViewById(R.id.showDataBtn);
        helper = new DatabaseOpenHelper(this);
    }
}
