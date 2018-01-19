package com.example.neeraj.mobilelearning;
import android.content.DialogInterface;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.*;
import android.widget.*;

import java.util.*;


/***
 * Ceylan, Rattu Text to Speech
 *
 *
 */

public class Speech extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech engine;
    Random rand;
    int answ1;
    String[] ans;
    int score = 1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        engine = new TextToSpeech(this, this);

        rechnen();

        t1 = (TextView) findViewById(R.id.scoret);

        final Button buttonleft = (Button) findViewById(R.id.buttonleft);
        buttonleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(buttonleft, v);
            }
        });

        final Button buttonmid = (Button) findViewById(R.id.buttonmid);
        buttonmid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(buttonmid, v);
            }
        });

        final Button buttonright = (Button) findViewById(R.id.buttonright);
        buttonright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(buttonright, v);
            }
        });

        final Button restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rechnen();
                score = 0;

            }
        });


        final Button audiob = (Button) findViewById(R.id.audiob);
        audiob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText(v);
            }
        });
    }

    /**
     * Die Meldung, Alert, die nach der richtigen Antwort kommt.
     *
     * @param view
     */
    public void showAlert(View view) {

        AlertDialog.Builder myalert = new AlertDialog.Builder(this);
        myalert.setMessage("Das war die richtige Antwort!").create();

        myalert.setPositiveButton(
                "Gut gemacht! Weiter gehts!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        rechnen();
                        dialog.cancel();
                    }
                });
        myalert.show();

    }

    public void setText(Button btn, View v){
        if (btn.getText().toString() == Integer.toString(answ1)) {
            t1.setText("Score: " + score);
            score++;
            showAlert(v);
        }
    }

    public void speakText(View v) {
        String textContents = Integer.toString(answ1);
        engine.speak(textContents, TextToSpeech.QUEUE_FLUSH, null, null);

    }

    /**
     * Methode für Buttons und deren Nummern
     */
    public void rechnen() {
        rand = new Random();
        // answ1 ist die richtige antwort
        answ1 = rand.nextInt(100) + 1;  //hier kommen dann die slider werte rein
        ans = new String[3];
        Random r1 = new Random();
        Random r2 = new Random();
        int unterg = 1;
        int oberg = 100;

        int wronganswer1 = r1.nextInt(oberg) + unterg;
        int wronganswer2 = r2.nextInt(oberg) + unterg;


        ans[0] = Integer.toString(answ1);
        ans[1] = Integer.toString(wronganswer1);
        ans[2] = Integer.toString(wronganswer2);


        List<Button> btns = new ArrayList<Button>(3);

        btns.add((Button) findViewById(R.id.buttonleft));
        btns.add((Button) findViewById(R.id.buttonmid));
        btns.add((Button) findViewById(R.id.buttonright));

        Collections.shuffle(btns);

        for (int i = 0; i < 3; i++) {
            btns.get(i).setText(ans[i]);
        }

        for (; ; ) {
            if (wronganswer1 == answ1 || wronganswer2 == answ1 || wronganswer2 == 0 || wronganswer1 == 0) {
                wronganswer1 = r1.nextInt(oberg) + unterg;
                wronganswer2 = r1.nextInt(oberg) + unterg;
            } else {
                break;
            }
        }

    }

    /**
     * Score - Methode
     */
    public void ergeb() {
    }

    @Override
    public void onInit(int i) {

        if (i == TextToSpeech.SUCCESS) {
            //Setting speech Language
            engine.setLanguage(Locale.ENGLISH);
            engine.setPitch(1);
        }
    }

}
