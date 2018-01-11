package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
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
    String[] items;*/
    private SeekBar seekBar;
    private TextView numAuswahl;
    public static int range;
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
    }
        /*
        this.dropdownStart = (Spinner) findViewById(R.id.spinnerStart);
        this.dropdownEnd = (Spinner) findViewById(R.id.spinnerEnd);
        for(int i = 0; i < 1000; i++) {
            this.items = new String[i];
        }*/


    /**
     * In dieser Methode sind die clickListener, die für den Play Button sowie für die Seekbar verantwortlich sind, definiert.
     */
    public void init() {
        //TextVIew für das Anzeigen von Zahlenbereich
        numAuswahl = (TextView) findViewById(R.id.numAuswahl);
        //Seekbar für den Zahlenbereich festzulegen
        seekBar = (SeekBar) findViewById(R.id.seekBarZahlen);
        seekBar.setMax(100);
        seekBar.setProgress(10);
        range = seekBar.getProgress();
        numAuswahl.setText("0 - " + seekBar.getProgress());//.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress1 = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int schritt = 10;
                progress = ((int) Math.round(progress / schritt)) * schritt;
                progress1 = progress;
                numAuswahl.setText(/*""+ progress1 + */"0 - " + progress1/*seekBar.getMax()*/);
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
                range = progress1;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                numAuswahl.setText("0 - " + progress1);//""+ progress1 + " - " + seekBar.getMax());
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT);
                range = progress1;
            }
        });
    }
}

