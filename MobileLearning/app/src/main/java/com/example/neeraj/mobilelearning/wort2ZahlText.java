package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.Locale;

/**
 * In dieser Methode werden zahlen in Text umgewandelt. Der Nuter kann eine Zahl eingeben, die wird in Form von Text auf dem Display aufgegeben.
 */
public class wort2ZahlText extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView zahl_eingabe;
    TextView zahl_wort;
    Button test_num_txt;
    String text = "";
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,numok,numdel,buttonback,buttonspeech; // Buttons
    private TextToSpeech tts; // Sprachausgabe Variable

    /**
     * Mehode onCreate, wird beim Erstellen aufgerufen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wort2_zahl_text);
        init();
        keyboard();
        tts = new TextToSpeech(this, this);

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wort2ZahlText.this, PlayActivity.class);
                startActivity(intent);
            }
        });

        buttonspeech = (Button) findViewById(R.id.buttonspeech);
        buttonspeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
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
        if (b.toString().equals("Ein")){
            b.append('s');
        }
        return b.toString();
    }

    /**
     * Konstruktor
     */
    public void init(){
        zahl_wort = (TextView)findViewById(R.id.zahl_wort);
        test_num_txt = (Button)findViewById(R.id.btn1);
        zahl_eingabe = (TextView) findViewById(R.id.zahl_eingabe);
    }

    /**
     * Methode keyboard, Keyboard setzen
     */
    public void keyboard(){
        num0 = (Button)findViewById(R.id.n0);
        num1 = (Button)findViewById(R.id.n1);
        num2 = (Button)findViewById(R.id.n2);
        num3 = (Button)findViewById(R.id.n3);
        num4 = (Button)findViewById(R.id.n4);
        num5 = (Button)findViewById(R.id.n5);
        num6 = (Button)findViewById(R.id.n6);
        num7 = (Button)findViewById(R.id.n7);
        num8 = (Button)findViewById(R.id.n8);
        num9 = (Button)findViewById(R.id.n9);
        numdel = (Button)findViewById(R.id.ndel);
        numok = (Button)findViewById(R.id.nok);

        // Buttons write Numbers into a string
        num0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(0);
                }
            });
        num1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(1);
                }
            });
        num2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(2);
                }
            });
        num3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(3);
                }
            });
        num4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(4);
                }
            });
        num5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(5);
                }
            });
        num6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(6);
                }
            });
        num7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(7);
                }
            });
        num8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(8);
                }
            });
        num9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setNum(9);
                }
            });
        numdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delNum();
            }
        });
        numok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textnum = zahl_eingabe.getText().toString();
                System.out.print(textnum);
                if(textnum=="") {
                    zahl_wort.setText("Zahl eingeben");
                }else{
                    int num = Integer.parseInt(textnum);
                    zahl_wort.setText("" + nice(num));
                }
            }
        });
    }

    /**
     * Methode setNum
     * @param num
     */
    public void setNum(int num){
        // Begrenzung auf 5 Stellen, da wahrscheinlich nicht mehr benötigt wird.
        if(text.length() < 5) {
            text += num;
            zahl_eingabe.setText(text);
        }
        zahl_eingabe.setText(text);

    }

    /**
     * Methode delNum
     */
    public void delNum() {
        String s = text;
        if (s == null || s.length() == 0) {
             text = s;
        }else {
            text = s.substring(0, s.length()-1);
        }
        zahl_eingabe.setText(text);
    }

    /**
     * Methode für Sprachausgabe
     */
    public void speakOut(){
        String text = "";
        text = zahl_wort.getText().toString();
        if (!text.equals("Zahl Eingeben")) tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    /**
     * Methode für Sprachausgabe
     */
    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    /**
     * Methode für Sprachausgabe
     */
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.GERMANY);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
}