package com.example.zohaibbutt.lab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A2 extends AppCompatActivity {
    static final int GET_RESULT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String txt = intent.getStringExtra(A1.EXTRA_MESSAGE);

        TextView t2Txt = findViewById(R.id.T2);
        t2Txt.setText("Hello " + txt);
        Button button = findViewById(R.id.B2);
        button.setOnClickListener(this::onClick);
    }
    // Goes to A3 when button is clicked
    public void onClick(View view){
        Intent intent = new Intent(getApplicationContext(), A3.class);
        startActivityForResult(intent, GET_RESULT);
    }

@Override
    // set the text from A3 to A2
    protected void onActivityResult(int req, int res, Intent data){
        if(GET_RESULT == req){
            if(res == RESULT_OK){
                String txt = data.getStringExtra("result");
                TextView t3Txt = findViewById(R.id.T3);
                t3Txt.setText(txt);
            }
        }
    }
}
