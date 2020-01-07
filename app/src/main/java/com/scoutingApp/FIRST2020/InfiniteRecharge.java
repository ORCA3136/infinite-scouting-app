package com.scoutingApp.FIRST2020;

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
    private boolean mainClimb = false;

    private int lowerCell = 0;
    private int innerCell = 0;
    private int outerCell = 0;
    
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
                "            Henry Morris" + System.lineSeparator() +
                "      Layout and Design:" + System.lineSeparator() +
                "            Cassidy Schiller" + System.lineSeparator() +
                "            Sam Slopey" + System.lineSeparator() +
                "            Em Brown" + System.lineSeparator() +
                "            Khai Little" + System.lineSeparator() +
                "            Jackie Lawton" + System.lineSeparator() +
                "Want to see your name here? Contact your team's collective representative to find out how to get involved with app development!";
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

    int getOuterCell() {
        return outerCell;
    }

    public void setOuterCell(int outerCell) {
        this.outerCell = outerCell;
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
    public boolean isAutonomous() {
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
    boolean isMainClimb() {
            return mainClimb;
        }
    private void setMainClimb(boolean mainClimb) {
            this.mainClimb = mainClimb;
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
    public void setSettingsHelpInfo(String settingsHelpInfo) {
            this.settingsHelpInfo = settingsHelpInfo;
        }
    boolean isSelected() {return selected; }
    void setSelected(boolean selected) { this.selected = selected; }
    boolean isRevolved() { return revolved; }
    void setRevolved(boolean revolved) { this.revolved = revolved; }

    
    void cellScore(int level) {
        if (level == 1) {
            lowerCell = lowerCell + 1;
        }
        else if (level == 2) {
            outerCell = outerCell + 1;
        }
        else if (level == 3) {
            innerCell = innerCell + 1;
        }
    }
    void hang() {
        if (!isMainClimb()) {setMainClimb(true);}
        if (isMainClimb()) {setMainClimb(false);}
    }
    void revolution() {
        if (!isRevolved()) {
            setRevolved(true);
        }
        if (isRevolved()) {
            setRevolved(false);
        }
    }
    void selection() {
        if (!isSelected()) {setSelected(true);}
        if (isSelected()) {setSelected(false);}
    }
}
