package com.example.neeraj.mobilelearning;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *In dieser Klasse wird eine Meldung, wenn der Nutzer alle antworten richtig beantwortet hat, ausgegeben.
 */

public class won extends Activity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.won);
        tv = (TextView) findViewById(R.id.score);
        Bundle b = getIntent().getExtras();
        int y = b.getInt("score")-1;
        tv.setText("FINAL SCORE:" + y);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
