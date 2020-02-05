package com.scoutingApp.FIRST2020;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.firebase.analytics.FirebaseAnalytics;

public class EndGame extends AppCompatActivity {

    private int currentOrientation = 1;

    public InfiniteRecharge getGame() {
        return (InfiniteRecharge) getIntent().getSerializableExtra("Game");
    }
    public PersistentData getData() {
        return (PersistentData) getIntent().getSerializableExtra("data");
    }

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

    public void heightMiddle() {
        getGame().setHangHeight("MIDDLE");
    }
    public void heightMidHigh() {
        getGame().setHangHeight("MIDHIGH");
    }
    public void heightMidLow() {
        getGame().setHangHeight("MIDLOW");
    }
    public void heightHigh() {
        getGame().setHangHeight("HIGH");
    }
    public void heightLow() {
        getGame().setHangHeight("LOW");
    }
    
    public void hangLocMiddle() {
        getGame().setHangLoc("MIDDLE");
    }
    public void hangLocMidLeft() {
        getGame().setHangLoc("MIDLEFT");
    }
    public void hangLocMidRight() {
        getGame().setHangLoc("MIDRIGHT");
    }
    public void hangLocLeft() {
        getGame().setHangLoc("LEFT");
    }
    public void hangLocRight() {
        getGame().setHangLoc("RIGHT");
    }

    public void midLevel(View view) {
        heightMiddle();
        hangLocMiddle();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midLeftLevel(View view) {
        heightMiddle();
        hangLocMidLeft();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midRightLevel(View view) {
        heightMiddle();
        hangLocMidRight();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void leftLevel(View view) {
        heightMiddle();
        hangLocLeft();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void rightLevel(View view) {
        heightMiddle();
        hangLocRight();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }

    public void midLeft(View view) {
        heightMiddle();
        hangLocMiddle();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midLeftLeft(View view) {
        heightMidHigh();
        hangLocMidLeft();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midRightLeft(View view) {
        heightMidLow();
        hangLocMidRight();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void leftLeft(View view) {
        heightHigh();
        hangLocLeft();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void rightLeft(View view) {
        heightLow();
        hangLocRight();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }

    public void midRight(View view) {
        heightMiddle();
        hangLocMiddle();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midLeftRight(View view) {
        heightMidLow();
        hangLocMidLeft();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midRightRight(View view) {
        heightMidHigh();
        hangLocMidRight();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void leftRight(View view) {
        heightLow();
        hangLocLeft();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void rightRight(View view) {
        heightHigh();
        hangLocRight();
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame);
        FirebaseAnalytics.getInstance(this).logEvent("ENDCreate", savedInstanceState);
    }

}
