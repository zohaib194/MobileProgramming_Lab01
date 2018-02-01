package com.example.zohaibbutt.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);

        Button button = findViewById(R.id.B3);
        button.setOnClickListener(this::onClick);
    }



    public void onClick(View view){
        Intent intent = new Intent();
        EditText content = findViewById(R.id.T4);
        String txt = content.getText().toString();
        intent.putExtra("result", txt);
        setResult(RESULT_OK, intent);
        finish();
    }
}
