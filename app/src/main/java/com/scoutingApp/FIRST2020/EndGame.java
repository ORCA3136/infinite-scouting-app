package com.scoutingApp.FIRST2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
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

    public void goBack(View view) {
        Intent goBack = new Intent(getApplicationContext(), MainActivity.class);
        goBack.putExtra("gamefromEG", getGame());
        goBack.putExtra("datafromEG", getGame());
        startActivity(goBack);
    }


    public void colorLevel(int button) {
        findViewById(R.id.centerButtonLevel).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.midLeftButtonLevel).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.midRightButtonLevel).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.leftButtonLevel).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.rightButtonLevel).setBackground(getDrawable(R.drawable.round));
        findViewById(button).getBackground().setTint(getResources().getColor(R.color.darkestPurple));
    }

    public void colorLeft(int button) {
        findViewById(R.id.centerButtonLeft).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.midLeftButtonLeft).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.midRightButtonLeft).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.leftButtonLeft).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.rightButtonLeft).setBackground(getDrawable(R.drawable.round));
        findViewById(button).getBackground().setTint(getResources().getColor(R.color.darkestPurple));
    }

    public void colorRight(int button) {
        findViewById(R.id.centerButtonRight).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.midLeftButtonRight).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.midRightButtonRight).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.leftButtonRight).setBackground(getDrawable(R.drawable.round));
        findViewById(R.id.rightButtonRight).setBackground(getDrawable(R.drawable.round));
        findViewById(button).getBackground().setTint(getResources().getColor(R.color.darkestPurple));
    }

    public void climbFail(View view) {
        getGame().setClimbFail(getGame().getClimbFail() + 1);
    }
    public void parkButton(View view) {
        getGame().park();
    }

    public void midLevel(View view) {
        heightMiddle();
        hangLocMiddle();
        colorLevel(R.id.centerButtonLevel);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midLeftLevel(View view) {
        heightMiddle();
        hangLocMidLeft();
        colorLevel(R.id.midLeftButtonLevel);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midRightLevel(View view) {
        heightMiddle();
        hangLocMidRight();
        colorLevel(R.id.midRightButtonLevel);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void leftLevel(View view) {
        heightMiddle();
        hangLocLeft();
        colorLevel(R.id.leftButtonLevel);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void rightLevel(View view) {
        heightMiddle();
        hangLocRight();
        colorLevel(R.id.rightButtonLevel);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }

    public void midLeft(View view) {
        heightMiddle();
        hangLocMiddle();
        colorLeft(R.id.centerButtonLeft);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midLeftLeft(View view) {
        heightMidHigh();
        hangLocMidLeft();
        colorLeft(R.id.midLeftButtonLeft);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midRightLeft(View view) {
        heightMidLow();
        hangLocMidRight();
        colorLeft(R.id.midRightButtonLeft);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void leftLeft(View view) {
        heightHigh();
        hangLocLeft();
        colorLeft(R.id.leftButtonLeft);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void rightLeft(View view) {
        heightLow();
        hangLocRight();
        colorLeft(R.id.rightButtonLeft);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }

    public void midRight(View view) {
        heightMiddle();
        hangLocMiddle();
        colorRight(R.id.centerButtonRight);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midLeftRight(View view) {
        heightMidLow();
        hangLocMidLeft();
        colorRight(R.id.midLeftButtonRight);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void midRightRight(View view) {
        heightMidHigh();
        hangLocMidRight();
        colorRight(R.id.midRightButtonRight);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void leftRight(View view) {
        heightLow();
        hangLocLeft();
        colorRight(R.id.leftButtonRight);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }
    public void rightRight(View view) {
        heightHigh();
        hangLocRight();
        colorRight(R.id.rightButtonRight);
        System.out.println(getGame().getHangHeight() + getGame().getHangLoc());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame);
        FirebaseAnalytics.getInstance(this).logEvent("ENDCreate", savedInstanceState);
    }

}

    
