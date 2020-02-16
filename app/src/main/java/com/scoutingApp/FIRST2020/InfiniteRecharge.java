package com.scoutingApp.FIRST2020;

import android.content.res.Resources;

import java.io.Serializable;

public class InfiniteRecharge implements Serializable {

    private Info info = new Info();
    void infoSet(String match, int team, String name, String alliance){
        info.setAlliance(alliance);
        info.setMatch(match);
        info.setTeam(team);
        info.setName(name);
    }


    private boolean autonomous = true;
    private boolean mainStart = false;
    private boolean mainDefense = false;
    private boolean endGameHang = false;
    private boolean endGamePark = false;

    private String hangHeight = "No Hang";
    private String hangLoc = "No Hang";

    private int lowerCell = 0;
    private int innerCell = 0;
    private int outerCell = 0;
    private int autoLowerCell = 0;
    private int autoInnerCell = 0;
    private int autoOuterCell = 0;
    
    private boolean revolved = false;
    private boolean selected = false;
    
    private boolean extrasRedCard = false;
    private boolean extrasYellowCard = false;
    private boolean noShow = false;
    private boolean movement = true;
    private int extrasFinalScore = 0;
    private String extrasNotes = "No Notes";

    private String settingsDisplay = " ";
    private int settingsDisplayNum = 0;
    private String settingsHelpInfo = "Press the 'cache' button to view all data since last offload" +
            System.lineSeparator() + "Press the 'local' button to view all unsent data." +
            System.lineSeparator() + "Press the 'next' button to view the next submission in that category." +
            System.lineSeparator() + "Press the 'clear' button to clear the screen." +
            System.lineSeparator() + "Press the 'submit' button to send in the local data on display.";

    String getMainHelpInfo() {
        return "MEET THIS YEAR'S DEVELOPERS!" + System.lineSeparator() +
                "      PROGRAMMING:" + System.lineSeparator() +
                "            Cassidy Schiller" + System.lineSeparator() +
                "            Mac Fraser" + System.lineSeparator() +
                "            Bradley Harker" + System.lineSeparator() +
                "            Henry Morris" + System.lineSeparator() +
                "            Jackie Lawton" + System.lineSeparator() +
                "            Cody Hale" + System.lineSeparator() +
                "      Layout and Design:" + System.lineSeparator() +
                "            Cassidy Schiller" + System.lineSeparator() +
                "            Jackie Lawton" + System.lineSeparator() +
                "            Emma Harper" + System.lineSeparator() +
                "            Sam Slopey" + System.lineSeparator() +
                "            Khai Little" + System.lineSeparator() +
                "Want to see your name here? Contact Cassidy Schiller at whoistherealjendavis@gmail.com or in person to find out how to get involved with app development!";
    }

    private int climbFail ;
    int selectionfail ;
    int revolutionfail ;

    public boolean isEndGamePark() {
        return endGamePark;
    }

    public void setEndGamePark(boolean endGamePark) {
        this.endGamePark = endGamePark;
    }

    int getAutoLowerCell() {
        return autoLowerCell;
    }

    private void setAutoLowerCell(int autoLowerCell) {
        this.autoLowerCell = autoLowerCell;
    }

    int getAutoInnerCell() {
        return autoInnerCell;
    }

    public void setAutoInnerCell(int autoInnerCell) {
        this.autoInnerCell = autoInnerCell;
    }

    int getAutoOuterCell() {
        return autoOuterCell;
    }

    public void setAutoOuterCell(int autoOuterCell) {
        this.autoOuterCell = autoOuterCell;
    }

    int getLowerCell() {
        return lowerCell;
    }

    public void setLowerCell(int lowerCell) {
        this.lowerCell = lowerCell;
    }

    int getInnerCell() {
        return innerCell;
    }

    public void setInnerCell(int innerCell) {
        this.innerCell = innerCell;
    }

    int getOuterCell() { return outerCell; }

    public void setOuterCell(int outerCell) {
        this.outerCell = outerCell;
    }

    public void setHangHeight(String hangHeight) {
        this.hangHeight = hangHeight;
    }

    public String getHangHeight() {
        return hangHeight;
    }

    public String getHangLoc() {
        return hangLoc;
    }

    public void setHangLoc(String hangLoc) {
        this.hangLoc = hangLoc;
    }

    String getExtrasNotes() {
        return extrasNotes;
    }
    void setExtrasNotes(String extrasNotes) {
        this.extrasNotes = extrasNotes;
    }
    Info getInfo() {
        return info;
    }
    public void setInfo(Info info) {
        this.info = info;
    }
    boolean isAutonomous() {
        return autonomous;
    }
    void setAutonomous(boolean autonomous) {
        this.autonomous = autonomous;
    }
    boolean isMainStart() {
        return mainStart;
    }
    void setMainStart(boolean mainStart) {
            this.mainStart = mainStart;
        }
    boolean isMainDefense() {
            return mainDefense;
        }
    void setMainDefense(boolean mainDefense) {
            this.mainDefense = mainDefense;
        }
    boolean isEndGameHang() {
            return endGameHang;
        }
    private void setEndGameHang(boolean endGameHang) {
            this.endGameHang = endGameHang;
        }
    boolean isExtrasRedCard() {
            return extrasRedCard;
        }
    void setExtrasRedCard(boolean extrasRedCard) {
            this.extrasRedCard = extrasRedCard;
        }
    boolean isExtrasYellowCard() {
            return extrasYellowCard;
        }
    void setExtrasYellowCard(boolean extrasYellowCard) {
            this.extrasYellowCard = extrasYellowCard;
        }
    boolean isNoShow() {
            return noShow;
        }
    void setNoShow(boolean noShow) {
            this.noShow = noShow;
        }
    boolean isMovement() {
            return movement;
        }
    void setMovement(boolean movement) {
            this.movement = movement;
        }
    int getExtrasFinalScore() {
            return extrasFinalScore;
        }
    void setExtrasFinalScore(int extrasFinalScore) {
            this.extrasFinalScore = extrasFinalScore;
        }
    String getSettingsDisplay() {
            return settingsDisplay;
        }
    void setSettingsDisplay(String settingsDisplay) {
            this.settingsDisplay = settingsDisplay;
        }
    public int getSettingsDisplayNum() {
            return settingsDisplayNum;
        }
    public void setSettingsDisplayNum(int settingsDisplayNum) {
            this.settingsDisplayNum = settingsDisplayNum;
        }
    String getSettingsHelpInfo() {
            return settingsHelpInfo;
        }
    boolean isSelected() {return selected; }
    void setSelected(boolean selected) { this.selected = selected; }
    boolean isRevolved() { return revolved; }
    void setRevolved(boolean revolved) { this.revolved = revolved; }

    
    void cellScore(int level) {
        if (level == 1) {
            setLowerCell(getLowerCell() + 1);
        }
        else if (level == 2) {
            setOuterCell(getOuterCell() + 1);
        }
        else if (level == 3) {
            setInnerCell(getInnerCell() + 1);
        }
    }

    void autoCellScore(int level) {
        if (level == 1) {
            setAutoLowerCell(getAutoLowerCell() + 1);
        }
        else if (level == 2) {
            setAutoOuterCell(getAutoOuterCell() + 1);
        }
        else if (level == 3) {
            setAutoInnerCell(getAutoInnerCell() + 1);
        }
    }

    void hang() {
        hangThread thread = new hangThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

    void park() {
        parkThread thread = new parkThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

    void revolution() {
        revolutionThread thread = new revolutionThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

    void selection() {
        selectionThread thread = new selectionThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }

//    public boolean unlikelyScores() {
//        if (//timeline is too close
//        ) {
//            return true;
//        }
//        else return false;
//    }

//Threads
    class hangThread implements Runnable {
        @Override
        public void run() {
            if (!isEndGameHang()) {
                setEndGameHang(true);}
            if (isEndGameHang()) {
                setEndGameHang(false);}
        }
    }

    class parkThread implements Runnable {
        @Override
        public void run() {
            if (!isEndGamePark()) {
                setEndGamePark(true);}
            if (isEndGamePark()) {
                setEndGamePark(false);}
        }
    }

    class revolutionThread implements Runnable {
        @Override
        public void run() {
            if (!isRevolved()) {setRevolved(true);}
            if (isRevolved()) {setRevolved(false);}
        }
    }

    class selectionThread implements Runnable {
        @Override
        public void run() {
            if (!isSelected()) {setSelected(true);}
            if (isSelected()) {setSelected(false);}
        }
    }

    public int getClimbFail() {
        return climbFail;
    }

    public void setClimbFail(int climbFail) {
        this.climbFail = climbFail;
    }



}
