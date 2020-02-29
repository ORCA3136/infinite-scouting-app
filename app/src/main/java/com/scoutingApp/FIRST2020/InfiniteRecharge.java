package com.scoutingApp.FIRST2020;

import java.io.Serializable;

class InfiniteRecharge implements Serializable {

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

    private int extrasFinalScore = 0;
    private String extrasNotes = "No Notes";

    private String settingsDisplay = " ";
    private String settingsHelpInfo = "Press the 'cache' button to view all unsent data." +
            System.lineSeparator() + "Press the 'next' button to view the next submission in that category." +
            System.lineSeparator() + "Press the 'clear' button to clear the screen." ;

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

    boolean isEndGamePark() {
        return endGamePark;
    }

    private void setEndGamePark(boolean endGamePark) {
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

    private void setAutoInnerCell(int autoInnerCell) {
        this.autoInnerCell = autoInnerCell;
    }

    int getAutoOuterCell() {
        return autoOuterCell;
    }

    private void setAutoOuterCell(int autoOuterCell) {
        this.autoOuterCell = autoOuterCell;
    }

    int getLowerCell() {
        return lowerCell;
    }

    private void setLowerCell(int lowerCell) {
        this.lowerCell = lowerCell;
    }

    int getInnerCell() {
        return innerCell;
    }

    private void setInnerCell(int innerCell) {
        this.innerCell = innerCell;
    }

    int getOuterCell() { return outerCell; }

    private void setOuterCell(int outerCell) {
        this.outerCell = outerCell;
    }

    void setHangHeight(String hangHeight) {
        this.hangHeight = hangHeight;
    }

    String getHangHeight() {
        return hangHeight;
    }

    String getHangLoc() {
        return hangLoc;
    }

    void setHangLoc(String hangLoc) {
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
    String getSettingsHelpInfo() {
            return settingsHelpInfo;
        }
    boolean isSelected() {return selected; }
    void setSelected(boolean selected) { this.selected = selected; }
    boolean isRevolved() { return revolved; }
    void setRevolved(boolean revolved) { this.revolved = revolved; }

    
    void cellScore(int level) {
        if (level == 1) {
            if (getLowerCell() <= 60) {setLowerCell(getLowerCell() + 1);}
        }
        else if (level == 2) {
           if (getOuterCell() <= 60) {setOuterCell(getOuterCell() + 1);}
        }
        else if (level == 3) {
           if (getInnerCell() <= 60) {setInnerCell(getInnerCell() + 1);}
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

    void park() {
        parkThread thread = new parkThread();
        Thread threadStart = new Thread(thread);
        threadStart.start();
    }


//Threads

    class parkThread implements Runnable {
        @Override
        public void run() {
            if (!isEndGamePark()) {
                setEndGamePark(true);}
            if (isEndGamePark()) {
                setEndGamePark(false);}
        }
    }

    int getClimbFail() {
        return climbFail;
    }

    void setClimbFail(int climbFail) {
        this.climbFail = climbFail;
    }



}
