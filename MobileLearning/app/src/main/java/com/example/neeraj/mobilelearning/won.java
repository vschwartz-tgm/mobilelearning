package com.example.neeraj.mobilelearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *In dieser Klasse wird eine Meldung, wenn der Nutzer alle antworten richtig beantwortet hat, ausgegeben.
 */

public class won extends Activity {
    TextView tv;
    public Button buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.won);
        tv = (TextView) findViewById(R.id.score);
        Bundle b = getIntent().getExtras();
        int y = b.getInt("score")-1;
        tv.setText("Finaler Spielstand:" + y);

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(won.this, PlayActivity.class);
                startActivity(intent);
            }
        });
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
