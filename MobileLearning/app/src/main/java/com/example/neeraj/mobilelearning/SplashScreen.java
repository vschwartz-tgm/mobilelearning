package com.example.neeraj.mobilelearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Dieser Aktivity ist als erstes zusehen, wenn die App gestartet wird.
 */
public class SplashScreen extends Activity {

    /**
     * Als erster wird für drei Sekunden Willkommensbild eingeblendet, dann wird man auf die MainActivity weitergeleitet.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 3 seconds
                    sleep(3*1000);

                    // After 5 seconds redirect to Main intent
                    Intent i=new Intent(getBaseContext(),PlayActivity.class);
                    startActivity(i);

                    // Remove activity
                    finish();

                } catch (Exception e) {
                    // Error
                }
            }
        };
        background.start();
    }

    /**
     * Methode onDestroy, beim Schließen
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}