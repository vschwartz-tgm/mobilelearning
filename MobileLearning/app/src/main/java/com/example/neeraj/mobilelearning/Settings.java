package com.example.neeraj.mobilelearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

/**
 * Diese Klasse soll für die Einstellungen zustädig sein.
 */
public class Settings extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        }
    }
/**
import android.os.Bundle;
import android.app.Activity;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
    TextView numberView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker_app);
        numberView = (TextView)findViewById(R.id.numberview);
        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberpicker);
        numberPicker.setMaxValue(100);       //1
        numberPicker.setMinValue(0);         //2
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.setOnValueChangedListener( new NumberPicker.
                OnValueChangeListener()) {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {
                numberView.setText("Selected number is " + newVal);
            }
        }
    }
}**/
