package com.example.neeraj.mobilelearning;

import android.content.ClipData;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import java.util.Random;

/**
 * Logik Klasse fü das Marke zu Zahl Spiel
 * Created by Rasic Benjamin on 09.05.2017.
 */

public class markezuzahl extends AppCompatActivity{
    //ImageView oldView, newView;
    //LinearLayout container;

    private int ergebnis, n; // Ergebnis für aufrechnen, n die zu setztende nummber
    TextView cnumber,win;
    Button rbutton;
    int range;

    /**
     * On Create uste the layout set a number add listenerst and the onclick for the reset button... it resets stuff
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        range = MainActivity.range;
        ergebnis = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.markezuzahl_layout);
        n = setRandomZahl(1,range);

        setRNumber(n);

        //rbutton = (Button)findViewById(R.id.markezuzahl_btn);
        //rbutton.setOnClickListener(new OnClickListener() {
        //@Override
        //public void onClick(View v) {
            //n = setRandomZahl(1,100);
            //setRNumber(n);
            //win = (TextView) findViewById(R.id.winner);
            //win.setText("Not yet.");
            //clearViews();

            //View einserchoice1 = View.findViewById(R.id.einserchoice1);
            //((ViewGroup) einserchoice1.getParent()).removeView(einserchoice1);
            //}
        //});



        findViewById(R.id.einser).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.zehner).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.hunderter).setOnTouchListener(new MyTouchListener());
        findViewById(R.id.tausender).setOnTouchListener(new MyTouchListener());

        findViewById(R.id.einserchoice1).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice1).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice1).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice1).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice2).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice2).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice2).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice2).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice3).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice3).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice3).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice3).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice4).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice4).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice4).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice4).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice5).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice5).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice5).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice5).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice6).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice6).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice6).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice6).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice7).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice7).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice7).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice7).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice8).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice8).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice8).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice8).setOnDragListener(new MyDragListener());

        findViewById(R.id.einserchoice9).setOnDragListener(new MyDragListener());
        findViewById(R.id.zehnerchoice9).setOnDragListener(new MyDragListener());
        findViewById(R.id.hunderterchoice9).setOnDragListener(new MyDragListener());
        findViewById(R.id.tausenderchoice9).setOnDragListener(new MyDragListener());


    }

    /**
     * Clear all the views
     */
    public void clearViews(){

    }

    /**
     * Checks if you have won and notifes you if so
     */
    public void checkWin(){
        if (ergebnis > n){
            win = (TextView) findViewById(R.id.winner);
            win.setText("Leider verloren!");

        } else if (ergebnis == n){
            ergebnis = 0;
            win = (TextView) findViewById(R.id.winner);
            win.setText("Gewonnen!");

        }
    }

    /**
     * Adds the value of the drag to the ergebnis and call the winning check
     * @param dragid
     */
    public void calculate(String dragid){
        if (dragid.equals("einser")) {
            ergebnis = ergebnis + 1;
            checkWin();
        }else if(dragid.equals("zehner")){
            ergebnis = ergebnis + 10;
            checkWin();
        }else if(dragid.equals("hunderter")) {
            ergebnis = ergebnis + 100;
            checkWin();
        }else if(dragid.equals("tausender")) {
            ergebnis = ergebnis + 1000;
            checkWin();
        }
    }

    /**
     * Calculate random number
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
     * Set the random nnumber
     * @param random
     */
    public void setRNumber(int random){
        cnumber = (TextView)findViewById(R.id.cnumber);
        int a = random;
        cnumber.setText(""+a);

    }


    /**
     * Handles reaction to use touch
     */
    private final class MyTouchListener implements OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                ClipData data = ClipData.newPlainText("", "");
                DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);

                view.startDrag(data, shadowBuilder, view, 0);

                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Handles reaction to user Drag
     */
    class MyDragListener implements OnDragListener {

        @Override

            public boolean onDrag(View v, DragEvent event) {
                int action = event.getAction();
                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        // do nothing
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                    case DragEvent.ACTION_DROP:

                        View view = (View) event.getLocalState();
                        LinearLayout container =  (LinearLayout) v;


                        String dragid = view.getResources().getResourceEntryName(view.getId());
                        Log.d("draggedid", dragid);



                        String cdrag = v.getResources().getResourceEntryName(v.getId());
                        Log.d("containerid", cdrag);


                        if (cdrag.equals("einserchoice1") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            //Log.d("nevergothere","i never get here");
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());

                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice1") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice1") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice1") && dragid.equals("tausender")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if (cdrag.equals("einserchoice2") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice2") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice2") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice2") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice3") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice3") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice3") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice3") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice4") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice4") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice4") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice4") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice5") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice5") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice5") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice5") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice6") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice6") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice6") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice6") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice7") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice7") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice7") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice7") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice8") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice8") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice8") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice8") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else if (cdrag.equals("einserchoice9") && dragid.equals("einser")){ // Right mark in the right field
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("zehnerchoice9") && dragid.equals("zehner")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("hunderterchoice9") && dragid.equals("hunderter")){
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;

                        }else if(cdrag.equals("tausenderchoice9") && dragid.equals("tausender")) {
                            calculate(dragid);
                            ImageView oldView = (ImageView) view;
                            ImageView newView = new ImageView(getApplicationContext());
                            newView.setImageBitmap(((BitmapDrawable) oldView.getDrawable()).getBitmap());
                            container.addView(newView);
                            break;
                        }else {
                            break;
                        }


                        case DragEvent.ACTION_DRAG_ENDED:
                        break;
                    }

                return true;
            }

        }
    }

