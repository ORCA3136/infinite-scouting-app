package com.scoutingApp.FIRST2020;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //class-specific variables

    static MainActivity mn;
    private PersistentData data = null;
    private InfiniteRecharge game = null;
    private static String dialogMessage = "";
    static Intent settings;
    static boolean selectionStatic = false;
    static boolean revolutionStatic = false;
    static int selectionFailStatic = 0;
    static int revolutionFailStatic = 0;
    static Runnable SC;
    static Runnable RC;

    // getters and setters

    public PersistentData getData() {
        return data;
    }

    public void setData(PersistentData data) {
        this.data = data;
    }

    public InfiniteRecharge getGame() { return game; }

    public void setGame(InfiniteRecharge game) { this.game = game; }

    public Intent getSettings() {
        Intent settings = new Intent(this, Settings.class);
        settings.putExtra("gamefromMAtoS", getGame());
        settings.putExtra("datafromMAtoS", getData());
        return settings;
    }

    public void setFinSettingsIntent() {
        MainActivity.settings = getSettings();
    }

    // methods to set or change variables, set ss timer, etc

    public void updateScoreText(int id, int score, String texty) {
        TextView text = findViewById(id);
        String label = texty + " (" + score + ")";
        text.setText(label);
    }

    public static class RevolutionDialog extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage("SUCCESS OR FAILURE?")
                    .setNegativeButton("FAILURE", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            revolutionFailStatic = revolutionFailStatic + 1;
                            Objects.requireNonNull(RevolutionDialog.this.getDialog()).dismiss();
                        }
                    })
                    .setPositiveButton("SUCCESS", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            revolutionStatic = true;
                            Objects.requireNonNull(RevolutionDialog.this.getDialog()).dismiss();
                            mn.runOnUiThread(RC);
                        }
                    })
            ;
            return name.create();
        }
    }

    public static class SelectionDialog extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage("SUCCESS OR FAILURE?")
                    .setNegativeButton("FAILURE", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            selectionFailStatic = selectionFailStatic + 1;
                            Objects.requireNonNull(SelectionDialog.this.getDialog()).dismiss();
                        }
                    })
                    .setPositiveButton("SUCCESS", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            selectionStatic = true;
                            Objects.requireNonNull(SelectionDialog.this.getDialog()).dismiss();
                            mn.runOnUiThread(SC);
                        }
                    })
            ;
            return name.create();
        }
    }

    public static class Dialogs extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage(dialogMessage)
                    .setNegativeButton(R.string.okiedokes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Objects.requireNonNull(Dialogs.this.getDialog()).dismiss();
                        }
                    });
            return name.create();
        }
    }

    public void makeADialog(final String message, final String tag) {
        dialogMessage = message;
        DialogFragment newFragment = new Dialogs();
        newFragment.show(getSupportFragmentManager(), tag);
    }

    public void stormDelay(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
        if (getData().getTimerPause() == 0) {
            Timer pauser = new Timer();
            pauser.scheduleAtFixedRate(new RemindTask2(), 1000, 1000);
        }
    }

    class RemindTask extends TimerTask {
        public void run() {
            getGame().setAutonomous(false);
        }
    }

    class RemindTask2 extends TimerTask {
        public void run() {
            if (getGame().isMainStart()) {
                getData().setTimerPause(getData().getTimerPause() + 1);
                TimerCheckThread thread = new TimerCheckThread();
                Thread threadStart = new Thread(thread);
                runOnUiThread(threadStart);
                if (getData().getTimerPause() >= 20) {
                    TeleOpTimer tel = new TeleOpTimer();
                    Thread telThread = new Thread(tel);
                    runOnUiThread(telThread);
                }
                if (getData().getTimerPause() >= 120) {
                    EndGameTimer end = new EndGameTimer();
                    Thread endThread = new Thread(end);
                    runOnUiThread(endThread);
                }
                if (getData().getTimerPause() >= 155) {
                    getGame().setMainStart(false);
                }
            }
        }
    }

    class TeleOpTimer implements Runnable {
        @Override
        public void run() {
            TextView timerText = findViewById(R.id.label);
            timerText.setText(R.string.tel);
        }
    }

    class EndGameTimer implements Runnable {
        @Override
        public void run() {
            TextView timerText = findViewById(R.id.label);
            timerText.setText(R.string.eg);
        }
    }

    public void updateTextView(String content, int id) {
        TextView nametext = findViewById(id);
        nametext.setText(content);
    }

    // methods called on create

    public void updateDisplayInfo() {
        updateTextView(getGame().getInfo().getName(), R.id.infoName);
        updateTextView(getGame().getInfo().getAlliance(), R.id.infoAlliance);
        updateTextView(getGame().getInfo().getTeam().toString(), R.id.infoTeam);
        updateTextView(getGame().getInfo().getMatch(), R.id.infoMatch);
    }
    public void dialogCheck() {
        DialogCheckThread thread = new DialogCheckThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }
    public void checkDataGame() {
        if (getIntent().hasExtra("gamefromS")) {
            setGame((InfiniteRecharge) getIntent().getSerializableExtra("gamefromS"));
        } else if (getIntent().hasExtra("gamefromEG")) {
            setGame((InfiniteRecharge) getIntent().getSerializableExtra("gamefromEG"));
        } else {
            setGame(new InfiniteRecharge());
        }
        if (getIntent().hasExtra("datafromS")) {
            setData((PersistentData) getIntent().getSerializableExtra("datafromS"));
        } else if (getIntent().hasExtra("datafromPS")) {
            setData((PersistentData) getIntent().getSerializableExtra("datafromPS"));
        } else if (getIntent().hasExtra("datafromEG")) {
            setData((PersistentData) getIntent().getSerializableExtra("datafromEG"));
        } else {
            setData(new PersistentData());
        }
    }
    public void colorSet(int id, int color) {
        findViewById(R.id.pg2).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
        findViewById(R.id.pg3).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
        findViewById(R.id.pg1).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
        findViewById(id).getBackground().setTint(getResources().getColor(color));
    }
    public void persistence() {
        if (getData().getTimerPause() > 0) {
            Timer pauser = new Timer();
            pauser.scheduleAtFixedRate(new RemindTask2(), 1000, 1000);
        }
        if (getGame().getAutoInnerCell() >= 0 || getGame().getAutoOuterCell() >= 0 || getGame().getAutoLowerCell() >= 0 ||getGame().getInnerCell() >= 0 || getGame().getOuterCell() >= 0 || getGame().getLowerCell() >= 0) {
            updateScoreText(R.id.pg1, (getGame().getLowerCell() + getGame().getAutoLowerCell()), "Lower");
            updateScoreText(R.id.pg2, (getGame().getOuterCell() + getGame().getAutoOuterCell()), "Outer");
            updateScoreText(R.id.pg3, (getGame().getInnerCell() + getGame().getAutoInnerCell()), "Inner");
        }
    }

    // threads

    class RevColor implements Runnable {
        @Override
        public void run() {
            findViewById(R.id.revolution).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
            findViewById(R.id.revolution).getBackground().setTint(getResources().getColor(R.color.darkOrange));
        }
    }

    class SelColor implements Runnable {
        @Override
        public void run() {
                findViewById(R.id.selection).setBackground(getDrawable(R.drawable.common_google_signin_btn_icon_light_normal_background));
                findViewById(R.id.selection).getBackground().setTint(getResources().getColor(R.color.darkOrange));
        }
    }

    class DialogCheckThread implements Runnable {
        @Override
        public void run() {
            if (getData().perSubData != null && getData().getSheet().getSheetPage() != null) {
                int x = Integer.parseInt(getData().getSheet().getSheetPage().get(getData().getRowNumber()).get(2).toString()); //current match number
                int y;
                try {y = Integer.parseInt(getData().getSheet().getSheetPage().get(getData().getRowNumber() - 1).get(2).toString());}
                catch (Exception e) {y = 0;}
                //last match number
                if (y != 0) {if (!(getData().getSheet().getSheetPage().get(getData().getRowNumber()).get(0).equals(getData().getSheet().getSheetPage().get(getData().getRowNumber() - 1).get(0))) && (x - 1 == y)) {
                    makeADialog("Please go find the next scouter, " + getData().getSheet().getSheetPage().get(getData().getRowNumber()).get(0), "handoff"); }
                }
            }
        }
    }

    class TimerCheckThread implements Runnable {
        @Override
        public void run() {
            TextView timerText = findViewById(R.id.timer);
            timerText.setText(String.valueOf(getData().getTimerPause()));
        }
    }

    class SettingsButtonThread implements Runnable {
        @Override
        public void run() {
            setFinSettingsIntent();
            startActivity(settings);
        }
    }

    class SubmitButtonThread implements Runnable {
        @Override
        public void run() {
            Intent psPage = new Intent(getApplicationContext(), PostSubmit.class);
            psPage.putExtra("gamefromMAtoPS", getGame());
            psPage.putExtra("datafromMAtoPS", getData());
            startActivity(psPage);
        }
    }


    // button methods

    public void settingsButton(View view) {
        SettingsButtonThread thread = new SettingsButtonThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

    public void revolutionButton(View view) {
        DialogFragment newFragment = new RevolutionDialog();
        newFragment.show(getSupportFragmentManager(), "Rev");
    }

    public void selectionButton (View view){
        DialogFragment newFragment = new SelectionDialog();
        newFragment.show(getSupportFragmentManager(), "Sel");
    }

    public void pg1(View view) {
        if (getGame().isMainStart()) {
            if (!getGame().isAutonomous()) {
                getGame().cellScore(1);
            }
            else {
                getGame().autoCellScore(1);
            }
            updateScoreText(R.id.pg1, (getGame().getLowerCell() + getGame().getAutoLowerCell()), "Lower");
            colorSet(R.id.pg1, R.color.darkOrange) ;
        }
        else makeADialog("Please start the game!", "gameStart");
    }

    public void pg2(View view) {
                if (getGame().isMainStart()) {
                    if (getGame().isAutonomous()) {
                        getGame().autoCellScore(2);
                    }
                    else {
                        getGame().cellScore(2);
                    }
                    updateScoreText(R.id.pg2, (getGame().getOuterCell() + getGame().getAutoOuterCell()), "Outer");
                    colorSet(R.id.pg2, R.color.darkOrange) ;
                }
        else makeADialog("Please start the game!", "gameStart");
    }

    public void pg3(View view) {
        if (getGame().isMainStart()) {
            if (getGame().isAutonomous()) {
                getGame().autoCellScore(3);
            }
            else {
                getGame().cellScore(3);
            }
            updateScoreText(R.id.pg3, (getGame().getInnerCell() + getGame().getAutoInnerCell()), "Inner");
            colorSet(R.id.pg3, R.color.darkOrange) ;
        }
        else makeADialog("Please start the game!", "gameStart");
    }

    public void helpButton(View view) {
        makeADialog(getGame().getMainHelpInfo(), "help");
    }

    public void startButton(View view) {
        if(getGame().isMainStart()) {colorSet(R.id.start3, R.color.darkOrange); }
        else {colorSet(R.id.start3, R.color.lightOrange) ;}
        if (!getGame().isMainStart()) {
            getGame().setMainStart(true);
            ((Button) findViewById(R.id.start3)).setText(R.string.stop);
            if (getData().getTimerPause() == 0) {
                stormDelay(20);
            } else if (getData().getTimerPause() <= 19) {
                getGame().setAutonomous(true);
                stormDelay(20 - getData().getTimerPause());
            }
            if (getData().getTimerPause() == 155) {
                DialogFragment newFragment = new TimeOver();
                newFragment.show(getSupportFragmentManager(), "TIME");
            }
        } else {
            getGame().setMainStart(false);
            ((Button) findViewById(R.id.start3)).setText(R.string.start);
            getGame().setAutonomous(false);
        }
    }

    public static class TimeOver extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder name = new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
            name.setMessage("Match time is done, you are being sent to the Post Submit page to submit your data")
                    .setNegativeButton(R.string.okiedokes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Objects.requireNonNull(TimeOver.this.getDialog()).dismiss();
                            Thread threadStart = new Thread(ST);
                            threadStart.start();
                        }
                    });
            return name.create();
        }
    }


    static Runnable ST;

    public void submitButton(View view) {
        SubmitButtonThread thread = new SubmitButtonThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

    public void endGameHang(View view) {
        if (getData().getTimerPause() > 120) {
            Intent egPage = new Intent(getApplicationContext(), EndGame.class);
            egPage.putExtra("gamefromMAtoEG", getGame());
            egPage.putExtra("datafromMAtoEG", getData());
            startActivity(egPage);
        }
        else {
            makeADialog("Endgame has yet to begin", "END");
        }
    }

    //on create, on start, save state, etc (overrides)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkDataGame();
        if (!getData().getSheet().getSheetID().equals("default")) {
            int rowNum = getData().getRowNumber();
            getGame().infoSet(
                    getData().getSheet().matchValue(rowNum),
                    Integer.parseInt(getData().getSheet().teamValue(rowNum)),
                    getData().getSheet().nameValue(rowNum),
                    getData().getPerAlliance()
            );
        } else {
            getGame().infoSet("0", 0, "0", "0");
        }
        updateDisplayInfo();
        dialogCheck();
        persistence();
        mn = MainActivity.this;
        SC = new SelColor();
        RC = new RevColor();
        ST = new SubmitButtonThread();
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
