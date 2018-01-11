package com.example.neeraj.mobilelearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * In dieser Klasse wird eine Meldung, wenn der Nutzer eine falsche Antwort gibt, ausgegeben.
 */
public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = (TextView) findViewById(R.id.textResult);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        if (Wort2Zahl.msg!=1) {
            textResult.setText("Leider Falsch! "+ /*Your points are*/"Dein Punktestand:" + " " + score);
        }else {
            textResult.setText("Zeit abgelaufen!! Dein Punktestand:" + " " + score);
        }

    }

    public void playagain(View o) {
        Intent intent = new Intent(this, Wort2Zahl.class);
        startActivity(intent);
        finish();

    }
}