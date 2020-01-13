package com.scoutingApp.FIRST2020;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class EndGame extends AppCompatActivity {
    String DEBUG_TAG="endgame" ;

    View leftBarLevel = findViewById(R.id.leftBarLevel);

    public void toLeftBar(MotionEvent event) {
        int x = event.getAction();
        switch(x) {
            case (MotionEvent.ACTION_DOWN) :
                Log.d(DEBUG_TAG, "Action was DOWN");

            case (MotionEvent.ACTION_MOVE) :
                Log.d(DEBUG_TAG,"Action was MOVE");

            case (MotionEvent.ACTION_UP) :
                Log.d(DEBUG_TAG,"Action was UP");

            case (MotionEvent.ACTION_CANCEL) :
                Log.d(DEBUG_TAG,"Action was CANCEL");

            case (MotionEvent.ACTION_OUTSIDE) :
                Log.d(DEBUG_TAG,"Movement occurred outside bounds " +
                        "of current screen element");

        }
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        super.onGenericMotionEvent(event) ;
        int xCoordinates = ((int) event.getX());

        int yCoordinates = ((int) event.getY());

            if((yCoordinates >= 50 && xCoordinates >= 50) || (yCoordinates <= 50 && xCoordinates <= 50)) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.clone(this, R.id.endgamelayout);
                    float biasedValue = 40;
                    float biasedValue2 = ((float) 0.4);
                    constraintSet.setVerticalBias(R.id.bottomBarLevel, biasedValue);
                    constraintSet.setVerticalBias(R.id.bottomBarRight, biasedValue2);
                    constraintSet.applyTo((ConstraintLayout) findViewById(R.id.endgamelayout));
                }
            }
            else {
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
         return true ;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame);
    }

}
