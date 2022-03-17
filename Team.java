/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccergame;

/**
 *
 * @author 30045900
 */
public class Team {

    private String teamName;
    private int tieNumber;
    private int totalWin;
    private int totalLoss;
    private int totalgoalAllowed;
    private int totalGoal;
    private static int nameNu = 1;

    public Team(String ipName) {
        teamName = ipName;
        nameNu++;
    }

    public Team() {
        teamName = "Team" + nameNu;
        nameNu++;
    }

// <editor-fold defaultstate="collapsed" desc="getters and setters">
    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @return the tieNumber
     */
    public int getTieNumber() {
        return tieNumber;
    }

    /**
     * @param tieNumber the tieNumber to set
     */
    public void setTieNumber(int tieNumber) {
        this.tieNumber = tieNumber;
    }

    /**
     * @return the totalWin
     */
    public int getTotalWin() {
        return totalWin;
    }

    /**
     * @param totalWin the totalWin to set
     */
    public void setTotalWin(int totalWin) {
        this.totalWin = totalWin;
    }

    /**
     * @return the totalLoss
     */
    public int getTotalLoss() {
        return totalLoss;
    }

    /**
     * @param totalLoss the totalLoss to set
     */
    public void setTotalLoss(int totalLoss) {
        this.totalLoss = totalLoss;
    }

    /**
     * @return the totalGoal
     */
    public int getTotalGoal() {
        return totalGoal;
    }

    /**
     * @param totalGoal the totalGoal to set
     */
    public void setTotalGoal(int totalGoal) {
        this.totalGoal = totalGoal;
    }

    /**
     * @return the totalgoalAllowed
     */
    public int getTotalgoalAllowed() {
        return totalgoalAllowed;
    }

    /**
     * @param totalgoalAllowed the totalgoalAllowed to set
     */
    public void setTotalgoalAllowed(int totalgoalAllowed) {
        this.totalgoalAllowed = totalgoalAllowed;
    }

// </editor-fold>
    @Override
    public String toString() {
        return "\nTeam: " + getTeamName()
                + "\nTotal WIns: " + getTotalWin()
                + "\nTotal Losses: " + getTotalLoss()
                + "\nTotal Ties: " + getTieNumber()
                + "\nTotal points scored: " + getTotalGoal()
                + "    Total points allowed: " + getTotalgoalAllowed() + "\n";

    }

}
