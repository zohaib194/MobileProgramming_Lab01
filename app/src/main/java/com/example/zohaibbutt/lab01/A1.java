package com.example.zohaibbutt.lab01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class A1 extends AppCompatActivity {
     static final String EXTRA_MESSAGE = "com.example.zohaibbutt.lab01.MESSAGE";
     static final String SPINNER_VAL = "spinner.key";
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.L1);
        Button button = findViewById(R.id.B1);

        //Shared pref
        this.sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // create an adapter and set default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_dropdown_item);
        // layout when the list appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);    // set the adapter to the spinner

        // Make spinner select the item that was selected before it quited
        spinner.setSelection(sharedPref.getInt(SPINNER_VAL, 0));

        button.setOnClickListener(this::onClick);
    }

    public void onClick(View view){

        Intent intent = new Intent(getApplicationContext(), A2.class);
        EditText eTxt = findViewById(R.id.T1); // get the text from field
        String txt = eTxt.getText().toString();     // convert the field to string
        intent.putExtra(EXTRA_MESSAGE, txt);
        startActivity(intent);
    }

    // Save the position of item selected in spinner
    public void saveKeyValue(){
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(SPINNER_VAL, ((Spinner)findViewById(R.id.L1)).getSelectedItemPosition());
        editor.commit();
    }
    //overwritting the onStop() so the position of selected item is saved in shared pref.
    public void onStop(){
        super.onStop();
        saveKeyValue();
    }
}
