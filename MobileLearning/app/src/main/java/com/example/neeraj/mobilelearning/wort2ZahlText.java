package com.example.neeraj.mobilelearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * In dieser Methode werden zahlen in Text umgewandelt. Der Nuter kann eine Zahl eingeben, die wird in Form von Text auf dem Display aufgegeben.
 */
public class wort2ZahlText extends AppCompatActivity {
    TextView zahl_eingabe;
    TextView zahl_wort;
    Button test_num_txt;
    String text = "";
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,numok,numdel,buttonback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wort2_zahl_text);
        init();
        keyboard();

        buttonback = (Button) findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wort2ZahlText.this, PlayActivity.class);
                startActivity(intent);
            }
        });
    }


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


    public void init(){
        zahl_wort = (TextView)findViewById(R.id.zahl_wort);
        test_num_txt = (Button)findViewById(R.id.btn1);
        zahl_eingabe = (TextView) findViewById(R.id.zahl_eingabe);
    }

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
                String newNum = textnum.replace("billion", "milliarde");
                int num = Integer.parseInt(newNum);
                zahl_wort.setText(""+nice(num));
            }
        });
    }

    public void setNum(int num){
        text += num;
        zahl_eingabe.setText(text);
    }

    public void delNum() {
        String s = text;
        if (s == null || s.length() == 0) {
             text = s;
        }else {
            text = s.substring(0, s.length()-1);
        }
        zahl_eingabe.setText(text);
    }
}
