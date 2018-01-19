package com.example.neeraj.mobilelearning;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Diese Klasse ist für das Quizspiel Wort2Zahl zuständig.
 *
 * @author Neeraj Rattu
 */
public class Wort2Zahl extends AppCompatActivity {
    TextView zahl_wort;
    Random rand;
    int answ1;
    String[] ans;
    int score = 1;
    static int msg = 0;
    TextView punkte,times;
    CounterClass timer;
    Button buttonleftup,buttonrightup,buttonleftdown,buttonrightdown,buttonback; // Buttons

    /**
     * In dieser Methode wird die rechnen() Methode aufgerufen.
     * alle
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wort2_zahl);
        rechnen();
        punkte = (TextView) findViewById(R.id.score);

        times = (TextView) findViewById(R.id.timers);
        times.setText("00:02:00");
        timer = new CounterClass(60000, 1000);
        timer.start();

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wort2Zahl.this, PlayActivity.class);
                startActivity(intent);
            }
        });

        buttonleftup = (Button) findViewById(R.id.btn1);
        buttonleftup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAns(buttonleftup.getText().toString());
            }
        });

        buttonrightup = (Button) findViewById(R.id.btn2);
        buttonrightup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAns(buttonrightup.getText().toString());
            }
        });

        buttonleftdown = (Button) findViewById(R.id.btn3);
        buttonleftdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAns(buttonleftdown.getText().toString());
            }
        });

        buttonrightdown = (Button) findViewById(R.id.btn4);
        buttonrightdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAns(buttonrightdown.getText().toString());
            }
        });

    }

    /**
     * Methode onStop, beim Stop aufgerufen
     */
    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
        finish();
    }

    /**
     * Mehode onPause, bei Pause aufgerufen
     */
    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
        finish();
    }

    /**
     * Methode setRandomZahl, generiert Random Zahl
     * @param min
     * @param max
     * @return
     */
    public int setRandomZahl(int min, int max) {
        Random r = new Random();
        int a = r.nextInt((max - min) + 1) + min;
        return a;
    }

    /**
     * Methode nice
     * @param a
     * @return
     */
    public String nice(int a){
        String numtotxt = NumberToWords.convert(a);
        StringBuilder b = new StringBuilder(numtotxt);
        int i = 0;
        do {
            b.replace(i, i + 1, b.substring(i,i + 1).toUpperCase());
            i =  b.indexOf(" ", i) + 1;
        } while (i > 0 && i < b.length());

        return b.toString();
    }

    /**
     * Methode rechnen
     */
    public void rechnen() {
        zahl_wort = (TextView)findViewById(R.id.zahl_wort);
        answ1 = setRandomZahl(0,/*Wenn's nicht funktioniert, hier Settings wegmachen und wieder MainActivity*/Settings.range);
        zahl_wort.setText(""+nice(answ1));
        rand = new Random();
        // answ1 ist die richtige antwort
        ans = new String[4];
        Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        int unterg = answ1-20;
        int oberg = answ1 + 20;
        if (unterg <=0){
            unterg = answ1+3;
        }

        int wronganswer1 = 0;
        if (answ1 > 20 && answ1 < 100) {
            String swap = "" + answ1;
            int len = swap.length();
            int lastLetter_pos = len - 1;
            int second_last_letter_pos = len - 2;

            String lastLetter = "" + swap.charAt(lastLetter_pos);
            String second_last_letter = "" + swap.charAt(second_last_letter_pos);
            if (lastLetter.equals(second_last_letter)){
                int a = Integer.parseInt(second_last_letter) + 5;
                second_last_letter = ""+a;
            }
            String sub_swap = "" + lastLetter + second_last_letter;
            wronganswer1 = Integer.parseInt(sub_swap);
        } else if (answ1 > 100) {
            String swap = "" + answ1;
            int len = swap.length();
            int lastLetter_pos = len - 1;
            int second_last_letter_pos = len - 2;

            String lastLetter = "" + swap.charAt(lastLetter_pos);
            String second_last_letter = "" + swap.charAt(second_last_letter_pos);
            if (lastLetter.equals(second_last_letter)){
                int a = Integer.parseInt(second_last_letter) + 5;
                second_last_letter = ""+a;
            }
            String sub_swap = swap.substring(0,len-2) + lastLetter + second_last_letter;
            wronganswer1 = Integer.parseInt(sub_swap);
        } else {
            wronganswer1 = r1.nextInt(oberg) + unterg;
        }
        //int wronganswer1 = r1.nextInt(oberg) + unterg;
        int wronganswer2 = r2.nextInt(oberg) + unterg;
        int wronganswer3 = r3.nextInt(oberg) + unterg;

        ans[0] = Integer.toString(answ1);
        ans[1] = Integer.toString(wronganswer1);
        ans[2] = Integer.toString(wronganswer2);
        ans[3] = Integer.toString(wronganswer3);

        List<Button> btns = new ArrayList<Button>(4);

        btns.add((Button) findViewById(R.id.btn1));
        btns.add((Button) findViewById(R.id.btn2));
        btns.add((Button) findViewById(R.id.btn3));
        btns.add((Button) findViewById(R.id.btn4));

        Collections.shuffle(btns);

        for (int i = 0; i < 4; i++) {
            btns.get(i).setText(ans[i]);
        }

        for (; ; ) {
            if (wronganswer1 == answ1 || wronganswer2 == answ1 || wronganswer3 == answ1 || wronganswer2 == 0 || wronganswer1 == 0 || wronganswer3 ==0) {
                wronganswer1 = r1.nextInt(oberg) + unterg;
                wronganswer2 = r2.nextInt(oberg) + unterg;
                wronganswer3 = r3.nextInt(oberg) + unterg;
            } else {
                break;
            }
        }

    }

    /**
     * Methode getAns
     * @param ans
     */
    public void getAns(String ans){
        if (ans.equals(Integer.toString(answ1))) {
            punkte.setText("Punktestand: " + score);
            score++;
        }else {
            Intent intent = new Intent(Wort2Zahl.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score-1);
            intent.putExtras(b);
            startActivity(intent);
            finish();
            timer.cancel();
        }

        if(score <=10){
            rechnen();
        }else {
            Intent intent = new Intent(Wort2Zahl.this,won.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
            timer.cancel();
        }
    }

    /**
     * Klasse Counterclass
     */
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            msg = 1;
            Intent intent = new Intent(Wort2Zahl.this,
                    ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score-1);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }
    }

}
