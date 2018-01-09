package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Diese Klasse soll für die Einstellungen zustädig sein.
 */
public class Settings extends AppCompatActivity {
    Spinner dropdownStart;
    Spinner dropdownEnd;
    String[] items;
    public Button buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, PlayActivity.class);
                startActivity(intent);
            }
        });
/*
        this.dropdownStart = (Spinner) findViewById(R.id.spinnerStart);
        this.dropdownEnd = (Spinner) findViewById(R.id.spinnerEnd);
        for(int i = 0; i < 1000; i++) {
            this.items = new String[i];
        }*/
    }
}
