package com.scoutingApp.FIRST2020;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class PostSubmit extends AppCompatActivity {
    // inherited class objects

    InfiniteRecharge game;

    PersistentData data;

    public InfiniteRecharge getGame() {
        return (InfiniteRecharge) getIntent().getSerializableExtra("Game2");
    }

    public PersistentData getData() {
        return (PersistentData) getIntent().getSerializableExtra("data2");
    }

    public void setData(PersistentData data) {
        this.data = data;
    }

    public void setGame(InfiniteRecharge game) {
        this.game = game;
    }

    public SubmittedData sub = new SubmittedData();

    public SubmittedData getSub() {
        return this.sub;
    }

    // methods to update the content of the UI

    private void updateTextView(String content, int id) {
        TextView nametext = findViewById(id);
        nametext.setText(content);
    }

    private void info() {
        updateTextView(getGame().getInfo().getName(), R.id.name);
        updateTextView(Integer.toString(getGame().getInfo().getTeam()), R.id.team);
        updateTextView((getGame().getInfo().getMatch()), R.id.match);
        if (getGame().getInfo().getAlliance().equalsIgnoreCase("red")) {
            ((ToggleButton) findViewById(R.id.toggleButton)).setChecked(true);
        }

    }

    // various methods called on submit

    public static class Dialogs4 extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage("Please add the final alliance score or a \"0\" placeholder!")
                    .setNegativeButton(R.string.okiedokes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Objects.requireNonNull(PostSubmit.Dialogs4.this.getDialog()).dismiss();
                        }
                    });
            return name.create();
        }
    }

    public String newString(int id) {
        TextView text = findViewById(id);
        return text.getText().toString();
    }

    public void goHome() {
        Intent main = new Intent(this, MainActivity.class);
        main.putExtra("data4", getData());
        startActivity(main);
    }

    public void toSubmission() {
        toSubmissionThread thread = new toSubmissionThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

    private void getConnected() {
        getConnectedThread thread = new getConnectedThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }
    //Threads

    class toSubmissionThread implements Runnable {
        @Override
        public void run() {
            getSub().setMainDefense(getGame().isMainDefense());
            getSub().setMainClimb(getGame().isEndGameHang());
            getSub().setExtrasRedCard(getGame().isExtrasRedCard());
            getSub().setExtrasYellowCard(getGame().isExtrasYellowCard());
            getSub().setNoShow(getGame().isNoShow());
            getSub().setMovement(getGame().isMovement());
            getSub().setExtrasFinalScore(getGame().getExtrasFinalScore());
            getSub().setTeam(getGame().getInfo().getTeam());
            getSub().setMatch(getGame().getInfo().getMatch());
            getSub().setName(getGame().getInfo().getName());
            getSub().setNotes(getGame().getExtrasNotes());
            getSub().setAlliance(getGame().getInfo().getAlliance());
            getSub().setRevolve(getGame().isRevolved());
            getSub().setSelect(getGame().isSelected());
            getSub().setPg1(getGame().getLowerCell());
            getSub().setPg2(getGame().getOuterCell());
            getSub().setPg3(getGame().getInnerCell());
            getSub().setApg1(getGame().getAutoLowerCell());
            getSub().setApg2(getGame().getAutoOuterCell());
            getSub().setApg3(getGame().getAutoInnerCell());
            getSub().setPark(getGame().isEndGamePark());
        }
    }
    class getConnectedThread implements Runnable {
        @Override
        public void run() {
            getData().getSheet().sender(getData().getSheet().mapTheSubmission(getData().perSubData.get(getData().getSheet().getSubNum()).setValues()), getData().perSubData.get(getData().getSheet().getSubNum()).getMatchNumber(), "tab" + PersistentData.getTabNum());
        }
    }
    //button method

    public void submitButtonPageTwo(View view) {
        if (!newString(R.id.typescorehere).equals("")) {
            getGame().getInfo().setName(newString(R.id.name));
            getGame().getInfo().setTeam(Integer.valueOf(newString(R.id.team)));
            getGame().getInfo().setMatch(newString(R.id.match));
            getGame().getInfo().setAlliance(((ToggleButton) findViewById(R.id.toggleButton)).getText().toString());
            getGame().setExtrasFinalScore(Integer.valueOf(newString(R.id.typescorehere)));
            toSubmission();
            getData().perSubData.add(getSub());
            getData().perCacheData.add(getGame().getInfo());
            getData().setRowNumber(getData().getRowNumber() + 1);
            getData().getSheet().setSubNum(getData().getSheet().getSubNum() + 1);
            getConnected();
            goHome();
        } else {
            DialogFragment newFragment = new Dialogs4();
            newFragment.show(getSupportFragmentManager(), "STOP");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_submit);
        info();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putSerializable("DATA", getData());
        savedInstanceState.putSerializable("GAME", getGame());
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setData((PersistentData) savedInstanceState.getSerializable("DATA"));
        setGame((InfiniteRecharge) savedInstanceState.getSerializable("SPACE"));
    }
}
