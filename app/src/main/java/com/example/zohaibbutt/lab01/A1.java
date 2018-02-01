package com.example.zohaibbutt.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A1 extends AppCompatActivity {
     static final String EXTRA_MESSAGE = "com.example.zohaibbutt.lab01.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.B1);


        button.setOnClickListener(this::onClick);
    }

    public void onClick(View view){

        Intent intent = new Intent(getApplicationContext(), A2.class);
        EditText eTxt = findViewById(R.id.T1); // get the text from field
        String txt = eTxt.getText().toString();     // convert the field to string
        intent.putExtra(EXTRA_MESSAGE, txt);
        startActivity(intent);
    }
}
