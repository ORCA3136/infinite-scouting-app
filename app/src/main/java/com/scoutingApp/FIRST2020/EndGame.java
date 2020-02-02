package com.scoutingApp.FIRST2020;

import android.os.Bundle;
import android.view.InputDevice;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.firebase.analytics.FirebaseAnalytics;

public class EndGame extends AppCompatActivity {

    private int currentOrientation = 1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int xCoordinates = ((int) event.getX());
        int yCoordinates = ((int) event.getY());

        if (currentOrientation == 1) {
                if ((yCoordinates >= 1000 && xCoordinates <= 540) || (yCoordinates <= 1000 && xCoordinates >= 540)) {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(this, R.layout.endgame);
                        float biasedValue = 40;
                        float biasedValue2 = ((float) 0.4);
                        constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue);
                        constraintSet.setVerticalBias(R.id.bottomBarRight, biasedValue2);
                        constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                        currentOrientation = 2;
                    }

                }
                //to right-up
                else {

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.clone(this, R.layout.endgame);
                        float biasedValue = 40;
                        float biasedValue2 = ((float) 0.4);
                        constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue);
                        constraintSet.setVerticalBias(R.id.bottomBarLeft, biasedValue2);
                        constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                        currentOrientation = 3;
                    }

                }
                //to left-up
            }

        if (currentOrientation == 2) {

            if ((yCoordinates <= 1000 && xCoordinates <= 540) || (yCoordinates >= 1000 && xCoordinates >= 540)) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(this, R.layout.endgame);
                    float biasedValue = 40;
                    float biasedValue2 = ((float) 0.4);
                    constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue2);
                    constraintSet.setVerticalBias(R.id.bottomBarRight, biasedValue);
                    constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                    currentOrientation = 1;
                }

            }
            //to level
        }

        if (currentOrientation == 3) {
            if ((yCoordinates >= 1000 && xCoordinates <= 540) || (yCoordinates <= 1000 && xCoordinates >= 540)) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(this, R.layout.endgame);
                    float biasedValue = 40;
                    float biasedValue2 = ((float) 0.4);
                    constraintSet.setVerticalBias(R.id.bottomBarLeft, biasedValue);
                    constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue2);
                    constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                    currentOrientation = 1;
                }

            }
            //to level
        }

        System.out.println(xCoordinates + "--x" + System.lineSeparator() + yCoordinates + "--y");
        return super.onGenericMotionEvent(event);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame);
        FirebaseAnalytics.getInstance(this).logEvent("ENDCreate", savedInstanceState);
    }

}
