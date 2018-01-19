package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by pzhanel on 09/01/2018.
 * Das ist der Screen, der Auftaucht, wenn auf den "Hilfe" Button geclickt wird.
 */

public class HelpScreen extends AppCompatActivity {
    ScrollView sv1, sv2, sv3, sv4;
    TextView headline1, headline2, headline3, headline4, headline5, answ1, answ2, answ3, answ4, answ5;
    Button buttonback; // Zurückbutton

    /**
     * Methode onCreate, wird beim Erstellen aufgerugen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_screen);

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpScreen.this, PlayActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Konstruktor
     */
    public void init(){
    }

}
