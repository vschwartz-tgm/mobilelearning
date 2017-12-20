package com.example.neeraj.mobilelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

/**
 * Diese Klasse soll für die Einstellungen zustädig sein.
 */
public class Settings extends AppCompatActivity {
    Spinner dropdownStart;
    Spinner dropdownEnd;
    String[] items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

/*
        this.dropdownStart = (Spinner) findViewById(R.id.spinnerStart);
        this.dropdownEnd = (Spinner) findViewById(R.id.spinnerEnd);
        for(int i = 0; i < 1000; i++) {
            this.items = new String[i];
        }*/
    }
}
