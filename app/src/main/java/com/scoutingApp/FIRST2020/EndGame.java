package com.scoutingApp.FIRST2020;

import android.os.Bundle;
import android.view.InputDevice;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class EndGame extends AppCompatActivity {

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        int xCoordinates = ((int) event.getX());

        int yCoordinates = ((int) event.getY());

        if (event.isFromSource(InputDevice.SOURCE_CLASS_POINTER)) {

            if ((yCoordinates >= 50 && xCoordinates >= 50) || (yCoordinates <= 50 && xCoordinates <= 50)) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(this, R.id.endgamelayout);
                    float biasedValue = 40;
                    float biasedValue2 = ((float) 0.4);
                    constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue);
                    constraintSet.setVerticalBias(R.id.bottomBarRight, biasedValue2);
                    constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                }
            } else {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(this, R.id.endgamelayout);
                    float biasedValue = 40;
                    float biasedValue2 = ((float) 0.4);
                    constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue);
                    constraintSet.setVerticalBias(R.id.bottomBarLeft, biasedValue2);
                    constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                }

            }
        }
        return super.onGenericMotionEvent(event);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame);
    }

}
