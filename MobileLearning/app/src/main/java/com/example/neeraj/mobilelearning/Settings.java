package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
=======
import android.widget.ImageButton;
import android.widget.SeekBar;
>>>>>>> 208614bd148c9e47d2a7790a0931fb4e5f069ad4
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Diese Klasse soll für die Einstellungen zustädig sein.
 */
public class Settings extends AppCompatActivity {
    /*Spinner dropdownStart;
    Spinner dropdownEnd;
    String[] items;
<<<<<<< HEAD
    public Button buttonback;
=======
>>>>>>> 208614bd148c9e47d2a7790a0931fb4e5f069ad4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
<<<<<<< HEAD

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, PlayActivity.class);
                startActivity(intent);
            }
        });
/*
=======
>>>>>>> 208614bd148c9e47d2a7790a0931fb4e5f069ad4
        this.dropdownStart = (Spinner) findViewById(R.id.spinnerStart);
        this.dropdownEnd = (Spinner) findViewById(R.id.spinnerEnd);
        for(int i = 0; i < 1000; i++) {
            this.items = new String[i];
        }*/
    private SeekBar seekBar;
    private TextView numAuswahl;
    public static int range;

    /**
     * In dieser Methode sind die clickListener, die für den Play Button sowie für die Seekbar verantwortlich sind, definiert.
     */
    public void init(){


        //TextVIew für das Anzeigen von Zahlenbereich
        numAuswahl = (TextView)findViewById(R.id.numAuswahl);
        //Seekbar für den Zahlenbereich festzulegen
        seekBar = (SeekBar)findViewById(R.id.seekBarZahlen);
        seekBar.setProgress(0);
        range = seekBar.getProgress();
        numAuswahl.setText(""+ seekBar.getProgress() + " - " + seekBar.getProgress());//.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress1 = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int schritt = 10;
                progress = ((int)Math.round(progress/schritt ))*schritt ;
                progress1 = progress;
                numAuswahl.setText(/*""+ progress1 + */"0 - " + progress1/*seekBar.getMax()*/);
                Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
                range = progress1;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                numAuswahl.setText("0 - " + progress1);//""+ progress1 + " - " + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "",Toast.LENGTH_SHORT);
                range = progress1;
            }
        });
    }

    /**
     * Hier wird einfach die init Methode, die alle Funktionen enthält, aufgerufen.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        init();
    }
}

