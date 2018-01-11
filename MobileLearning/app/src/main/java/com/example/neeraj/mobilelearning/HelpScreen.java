package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by pzhanel on 09/01/2018.
 * Das ist der Screen, der Auftaucht, wenn auf den "Hilfe" Button geclickt wird.
 */

public class HelpScreen extends AppCompatActivity {

    Button buttonback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_screen);
        //init();

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpScreen.this, PlayActivity.class);
                startActivity(intent);
            }
        });
    }

    public void init(){

    }

}
