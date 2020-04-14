package com.scoutingApp.FIRST2020;

import android.annotation.SuppressLint;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

class PersistentData implements Serializable {
    //local/cached data arrays

    ArrayList<SubmittedData> perSubData = new ArrayList<>();
    ArrayList<Info> perCacheData = new ArrayList<>();

    //variables that remain consistent

    private int timerPause;
    private String perAlliance;
    private int rowNumber = 0;
    private SheetsAccess sheet = new SheetsAccess();
    private static int tabNum;
    private boolean timeSend;
    @SuppressLint("UseSparseArrays")
    HashMap<Integer, Integer> map = new HashMap<>();

    boolean isTimeSend() {
        return timeSend;
    }
    void setTimeSend(boolean timeSend) {
        this.timeSend = timeSend;
    }
    static int getTabNum() {
        return tabNum;
    }
    static void setTabNum(int tabNum) {
        PersistentData.tabNum = tabNum;
    }
    int getTimerPause() {
        return timerPause;
    }
    void setTimerPause(int timerPause) {
        this.timerPause = timerPause;
    }
    SheetsAccess getSheet() {
        return sheet;
    }
    String getPerAlliance() {
        return perAlliance;
    }
    void setPerAlliance(String perAlliance) {
        this.perAlliance = perAlliance;
    }
    int getRowNumber() {
        return rowNumber;
    }
    void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }


}
