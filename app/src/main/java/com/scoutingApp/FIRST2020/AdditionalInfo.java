package com.scoutingApp.FIRST2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AdditionalInfo extends AppCompatActivity {
    // inherited class objects

    public InfiniteRecharge getGame() {
        return (InfiniteRecharge) getIntent().getSerializableExtra("Game4");
    }
    public PersistentData getData() {
        return (PersistentData) getIntent().getSerializableExtra("data4");
    }

    // button and switch methods

    public void redSwitch(View view) {
        if (!getGame().isExtrasRedCard()) { getGame().setExtrasRedCard(true);}
        else {getGame().setExtrasRedCard(false);}
    }
    public void yellowSwitch(View view) {
        if (!getGame().isExtrasYellowCard()) { getGame().setExtrasYellowCard(true);}
        else {getGame().setExtrasYellowCard(false);}
    }
    public void noShowSwitch(View view) {
        if (!getGame().isNoShow()) { getGame().setNoShow(true);}
        else {getGame().setNoShow(false);}
    }
    public void moveSwitch(View view) {
        if (getGame().isMovement()) { getGame().setMovement(false); }
        else {getGame().setMovement(true);}
    }
    public void backButton(View view) {
        EditText notes = findViewById(R.id.notes);
        getGame().setExtrasNotes(notes.getText().toString());
        Intent backHome = new Intent(this, MainActivity.class);
        backHome.putExtra("game5", getGame());
        backHome.putExtra("data5", getData());
        startActivity(backHome);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addinfo);
        EditText notes = findViewById(R.id.notes);
        notes.setText(getGame().getExtrasNotes());
    }
}
