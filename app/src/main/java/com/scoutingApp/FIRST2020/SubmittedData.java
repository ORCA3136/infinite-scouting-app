package com.scoutingApp.FIRST2020;


import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubmittedData implements Serializable {
    //each instance of this class is a final submission object
    private boolean mainDefense;
    private boolean mainClimb = false;
    private String height;
    private String loc;
    private boolean park;

    private int extrasFinalScore;

    private HashMap cycleTime;

    private int cycleAverage() {
        int avg = 0;
        int divisor = 0;
        for (int x = 2; x < apg1 + apg2 + apg3 + pg1 + pg2 + pg3; x ++) {
            avg += Integer.parseInt(cycleTime.get(x).toString());
            divisor = x - 1;
        }
        if (divisor != 0) {return avg / divisor;}
        else return 0;
    }

    private int team;
    private String match = "";
    private String name = "";
    private String alliance = "";
    private String notes = "";
    private int selectionfail;
    private int climbFail ;
    private int revolutionfail;
    private boolean revolve;
    private boolean select;
    private int pg1;
    private int pg2;
    private int pg3;
    private int apg1;
    private int apg2;
    private int apg3;

    private boolean trench;

    private boolean climblevel;

    private boolean ground_pickup;

    private boolean yellowcard;

    private boolean redcard;

    private boolean nomovement;

    private boolean noshow;

    List<Object> setValues() {
        return Arrays.asList(
            ((Object)mainDefense), //1
            mainClimb, //2
            redcard, //3
            yellowcard, //4
            noshow, //5
            nomovement, //6
            extrasFinalScore, //7
            team, //8
            match, //9
            name, //10
            alliance, //11
            notes, //12
            revolve,
            select, //14
            pg1,
            pg2, //16
            pg3,
            apg1, //17
            apg2,
            apg3, //18
            park,
                climblevel, //20
                ground_pickup,
                trench, //22
                revolutionfail,
                selectionfail, //24
                climbFail,
                cycleAverage(), //26
                height,
                loc //28
        );
    }

    void setCycleTime(HashMap cycleTime) {
        this.cycleTime = cycleTime;
    }
    void setclimbFail(int climbFail) {
        this.climbFail = climbFail;}
    void setSelectionfail(int selectionfail) {
        this.selectionfail = selectionfail;
    }
    void setRevolutionfail(int revolutionfail) {
        this.revolutionfail = revolutionfail;
    }
    void setTrench(boolean trench) {
        this.trench = trench;
    }
    void setYellowcard(boolean yellowcard) {
        this.yellowcard = yellowcard;
    }
    void setClimblevel(boolean climblevel) {
        this.climblevel = climblevel;
    }
    void setGround_pickup(boolean ground_pickup) {
        this.ground_pickup = ground_pickup;
    }
    void setRedcard(boolean redcard) {
        this.redcard = redcard;
    }
    void setNomovement(boolean nomovement) {
        this.nomovement = nomovement;
    }
    void setNoshow(boolean noshow) {
        this.noshow = noshow;
    }
    void setPark(boolean park) { this.park = park; }
    void setApg1(int apg1) { this.apg1 = apg1; }
    void setApg2(int apg2) { this.apg2 = apg2; }
    void setApg3(int apg3) { this.apg3 = apg3; }
    void setRevolve(boolean revolve) {
        this.revolve = revolve;
    }
    void setSelect(boolean select) {
        this.select = select;
    }
    void setPg1(int pg1) {
        this.pg1 = pg1;
    }
    void setPg2(int pg2) {
        this.pg2 = pg2;
    }
    void setPg3(int pg3) {
        this.pg3 = pg3;
    }

    void setHeight(String height) {
        this.height = height;
    }

    void setLoc(String loc) {
        this.loc = loc;
    }

    void setNotes(String notes) {this.notes = notes;}
    void setMainDefense(boolean mainDefense) {this.mainDefense = mainDefense;}
    void setMainClimb(boolean mainClimb) {this.mainClimb = mainClimb;}
    void setExtrasFinalScore(int extrasFinalScore) {this.extrasFinalScore = extrasFinalScore;}
    void setTeam(int team) {this.team = team;}
    void setMatch(String match) {this.match = match;}
    public void setName(String name) {this.name = name;}
    void setAlliance(String alliance) {this.alliance = alliance;}

    String getMatchNumber() {return match;}
}
