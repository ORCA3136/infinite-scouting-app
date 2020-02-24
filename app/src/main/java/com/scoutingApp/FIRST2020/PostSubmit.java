package com.scoutingApp.FIRST2020;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Objects;

public class PostSubmit extends AppCompatActivity {
    // inherited class objects

    InfiniteRecharge game;

    PersistentData data;

    boolean isItBlue;

    public InfiniteRecharge getGame() {
        return (InfiniteRecharge) getIntent().getSerializableExtra("gamefromMAtoPS");
    }

    public PersistentData getData() {
        return (PersistentData) getIntent().getSerializableExtra("datafromMAtoPS");
    }

    public void setData(PersistentData data) {
        this.data = data;
    }

    public void setGame(InfiniteRecharge game) {
        this.game = game;
    }

    public void color(View view) {
        if (isItBlue) {
            findViewById(R.id.toggleButton).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
            findViewById(R.id.toggleButton).getBackground().setTint(getResources().getColor(R.color.coolRed));
            isItBlue = false;
        }
        else {
            findViewById(R.id.toggleButton).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
            findViewById(R.id.toggleButton).getBackground().setTint(getResources().getColor(R.color.coolBlue));
            isItBlue = true;
        }
    }

    public SubmittedData sub = new SubmittedData();

    public SubmittedData getSub() {
        return this.sub;
    }

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

    boolean trench;
    boolean climblevel;
    boolean ground_pickup;
    boolean yellowcard;
    boolean redcard;
    boolean nomovement;
    boolean noshow;
    public boolean isTrench() {
        return trench;
    }
    public void setTrench(boolean trench) {
        this.trench = trench;
    }
    public boolean isYellowcard() {
        return yellowcard;
    }
    public void setYellowcard(boolean yellowcard) {
        this.yellowcard = yellowcard;
    }
    public boolean isClimblevel() {
        return climblevel;
    }
    public void setClimblevel(boolean climblevel) {
        this.climblevel = climblevel;
    }
    public boolean isGround_pickup() {
        return ground_pickup;
    }
    public void setGround_pickup(boolean ground_pickup) {
        this.ground_pickup = ground_pickup;
    }
    public boolean isRedcard() {
        return redcard;
    }
    public void setRedcard(boolean redcard) {
        this.redcard = redcard;
    }
    public boolean isNomovement() {
        return nomovement;
    }
    public void setNomovement(boolean nomovement) {
        this.nomovement = nomovement;
    }
    public boolean isNoshow() {
        return noshow;
    }
    public void setNoshow(boolean noshow) {
        this.noshow = noshow;
    }

    public static class Dialogs4 extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage("Please add the final alliance score, name, team, match, and/or a \"0\" placeholder!")
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
        main.putExtra("datafromPS", getData());
        startActivity(main);
    }

    public void climbEtcSet() {
        if (!getGame().getHangHeight().equals("No Hang") || !getGame().getHangLoc().equals("No Hang")) {
            getSub().setMainClimb(true);
        }
        //sets boolean climb value ^^
        getSub().setHeight(getGame().getHangHeight());
        //sets climb height ^^
        getSub().setLoc(getGame().getHangLoc());
        //sets climb location
        getSub().setclimbFail(getGame().getClimbFail());
        //sets # of fails
        getSub().setPark(getGame().isEndGamePark());
        //sets park boolean
    }

    public void panelSet() {
        getSub().setSelectionfail(getGame().selectionfail);
        getSub().setRevolutionfail(getGame().revolutionfail);
        getSub().setRevolve(getGame().isRevolved());
        getSub().setSelect(getGame().isSelected());
    }

    public void switchesSet() {
        getSub().setClimblevel((isClimblevel()));
        getSub().setGround_pickup((isGround_pickup()));
        getSub().setYellowcard((isYellowcard()));
        getSub().setNoshow((isNoshow()));
        getSub().setTrench((isTrench()));
        getSub().setRedcard((isRedcard()));
        getSub().setNomovement((isNomovement()));
    }

    public void infoForSub() {
        if ((getGame().getInfo().getTeam()) != 0) {
            getSub().setTeam(getGame().getInfo().getTeam());
        }
        else {
            getSub().setTeam(9999);
        }
        if (!getGame().getInfo().getMatch().equals("0") && !getGame().getInfo().getMatch().equals("")) {
            getSub().setMatch(getGame().getInfo().getMatch());
        }
        else {
            getSub().setMatch("-1");
        }
        if (!getGame().getInfo().getName().equals("0")) {
            getSub().setName(getGame().getInfo().getName());
        }
        else {
            getSub().setName("Jackie Doe");
        }
        if (!getGame().getExtrasNotes().equals("") && getGame().getExtrasNotes() != null) {
            getSub().setNotes(getGame().getExtrasNotes());
        }
        else {
            getSub().setNotes("No Notes");
        }
        if (getGame().getInfo().getAlliance() != null) {
            getSub().setAlliance(getGame().getInfo().getAlliance());
        }
        else {
            getSub().setAlliance("GREEN");
        }
    }

    public void scoresForSub() {
        getSub().setPg1(getGame().getLowerCell());
        getSub().setPg2(getGame().getOuterCell());
        getSub().setPg3(getGame().getInnerCell());
        getSub().setApg1(getGame().getAutoLowerCell());
        getSub().setApg2(getGame().getAutoOuterCell());
        getSub().setApg3(getGame().getAutoInnerCell());
        //cell scores
        getSub().setExtrasFinalScore(getGame().getExtrasFinalScore());
        //final score
        getSub().setCycleTime(getData().map);
        //cycle time
    }

    public void toSubmission() {
        getSub().setMainDefense(getGame().isMainDefense());
        climbEtcSet();
        scoresForSub();
        infoForSub();
        switchesSet();
        climbEtcSet();
        panelSet();
    }

    private void getConnected() {
        getData().getSheet().sender(getData().getSheet().mapTheSubmission(getData().perSubData.get(getData().getSheet().getSubNum()).setValues()), getData().perSubData.get(getData().getSheet().getSubNum()).getMatchNumber(), "tab" + PersistentData.getTabNum());
    }

    public void areTheyChecked() {
        setTrench(((Switch) findViewById(R.id.under_trench)).isChecked());

        setGround_pickup( ((Switch)findViewById(R.id.ground_pickup)).isChecked());

        setClimblevel( ((Switch)findViewById(R.id.is_climb_level)).isChecked());

        setNoshow( ((Switch)findViewById(R.id.no_show)).isChecked());

        setYellowcard( ((Switch)findViewById(R.id.yellow_card)).isChecked());

        setRedcard( ((Switch)findViewById(R.id.red_card)).isChecked());

        setNomovement( ((Switch)findViewById(R.id.no_movement)).isChecked());
    }

    public void submitButtonPageTwo(View view) {
        if (!newString(R.id.typescorehere).equals("") && !newString(R.id.name).equals("") && !newString(R.id.match).equals("") && !newString(R.id.team).equals("")) {
            getGame().getInfo().setName(newString(R.id.name));
            getGame().getInfo().setTeam(Integer.valueOf(newString(R.id.team)));
            getGame().getInfo().setMatch(newString(R.id.match));
            getGame().getInfo().setAlliance(((ToggleButton) findViewById(R.id.toggleButton)).getText().toString());
            getGame().setExtrasNotes(((EditText) findViewById(R.id.notes)).getText().toString());
            getGame().setExtrasFinalScore(Integer.valueOf(newString(R.id.typescorehere)));
            areTheyChecked();
            toSubmission();
            getData().perSubData.add(getSub());
            getData().perCacheData.add(getGame().getInfo());
            getData().setRowNumber(getData().getRowNumber() + 1);
            getData().getSheet().setSubNum(getData().getSheet().getSubNum() + 1);
            getData().getSheet().contextual = this;
            getConnected();
            getData().setTimerPause(0);
            goHome();
        } else {
            DialogFragment newFragment = new Dialogs4();
            newFragment.show(getSupportFragmentManager(), "STOP");
        }
    }

    public static class TimeOver extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage("Match time is over! You have been sent to the post-submit page to submit your data.")
                    .setNegativeButton(R.string.okiedokes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Objects.requireNonNull(TimeOver.this.getDialog()).dismiss();
                        }
                    });
            return name.create();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_submit);
        info();
        if (getGame().getInfo().getAlliance().equalsIgnoreCase("red")) {
            findViewById(R.id.toggleButton).setBackgroundColor(getResources().getColor(R.color.coolRed));
            isItBlue = false;
        }
        else {
            findViewById(R.id.toggleButton).setBackgroundColor(getResources().getColor(R.color.coolBlue));
            isItBlue = true;
        }
        FirebaseAnalytics.getInstance(this).logEvent("PSCreate", savedInstanceState);
        if (getData().isTimeSend()) {
            DialogFragment newFragment = new TimeOver();
            newFragment.show(getSupportFragmentManager(), "TIMER");
            getData().setTimeSend(false);
        }
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
        setGame((InfiniteRecharge) savedInstanceState.getSerializable("GAME"));
    }
}
