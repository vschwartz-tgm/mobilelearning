package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Main Activity ist die Menu Aktivität der App
 * Hier kann main den Zahlenberich auswählen. Dann gelangt man zu den Spielen Menü(PlayActivität)
 */
public class MainActivity extends AppCompatActivity {
    public ImageButton setting_btn;
    public ImageButton play_btn;
    private SeekBar seekBar;
    private TextView numAuswahl;
    public static int range;

    /**
     * In dieser Methode sind die clickListener, die für den Play Button sowie für die Seekbar verantwortlich sind, definiert.
     */
    public void init(){

        play_btn = (ImageButton)findViewById(R.id.play_button);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });

        setting_btn = (ImageButton)findViewById(R.id.setting_button);
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
            }
        });

        //TextVIew für das Anzeigen von Zahlenbereich
        numAuswahl = (TextView)findViewById(R.id.numAuswahl);
        //Seekbar für den Zahlenbereich festzulegen
        seekBar = (SeekBar)findViewById(R.id.seekbar);
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
        setContentView(R.layout.activity_main);
        init();
    }
}
