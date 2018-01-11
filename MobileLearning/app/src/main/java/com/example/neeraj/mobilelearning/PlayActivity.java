package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * In dieser Klasse wirden alle Buttons mit jeweiliger Activity verlinkt.
 */
public class PlayActivity extends AppCompatActivity {

    public Button wort2zahl,wort2zahltxt,markezuzahl,settings,perlezuzahl,info;

    public void init(){
        // Button, welcher für das Spiel Wort2Zahl zustädig ist.
        wort2zahl = (Button)findViewById(R.id.word_to_num);
        wort2zahl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this,Wort2Zahl.class);
                startActivity(intent);
            }
        });

        // Button, welcher für das Spiel Wort2ZahlTest zustädig ist.
        wort2zahltxt = (Button)findViewById(R.id.word_to_num_txt);
        wort2zahltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this,wort2ZahlText.class);
                startActivity(intent);
            }
        });

        // Button, welcher für das Spiel MarkeZuZahl zustädig ist.
        markezuzahl = (Button)findViewById(R.id.markezahl);
        markezuzahl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, markezuzahl.class);
                startActivity(intent);
            }
        });

        // Button, welcher für das Settingmenü zustädig ist.
        settings = (Button)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        Button
        settings = (Button)findViewById(R.id.info);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, HelpScreen.class);
                startActivity(intent);
            }
        });

        // Button, welcher für das Spiel PerleZuZahl zustädig ist.
        perlezuzahl = (Button)findViewById(R.id.perle_zu_zahl);
        perlezuzahl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayActivity.this, PerleZuZahl.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Hier wird die Methode init() aufgerufen.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        init();
    }


}
