/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccergame;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 30045900
 */
public class Game {

    private int tempDay;
    private double avTempSeason;
    private String Game;
    private static int gameNumber = 1;
    Team team1, team2;
    private int homeScore;
    private int awayScore;
    private int higestTemp = 0;
    private static ArrayList<Game> gameRecord = new ArrayList<>();
    Scheduler sc = new Scheduler();

    public Game(Team t1, Team t2) {
        tempDay = sc.getTempInput();
        team1 = t1;
        team2 = t2;
        scoreMaker(t1, t2);

        Game = "Game #" + getGameNumber();
        
        gameNumber++;
        gameRecord.add(this);
    }
// <editor-fold defaultstate="collapsed" desc="getters and setters">

    public int getTempDay() {
        return tempDay;
    }

    public void setTempDay(int tempDay) {
        this.tempDay = tempDay;
    }

    public double getAvTempSeason() {
        return avTempSeason;
    }

    public void setAvTempSeason(double avTempSeason) {
        this.avTempSeason = avTempSeason;
    }

    public String toString() {
        return Game
                + "\nTemperature: " + tempDay
                + "\n" + team1 + " goal score: " + getHomeScore()
                + "\n" + team2 + " goal score: " + getAwayScore();

    }

    /**
     * @return the gameNumber
     */
    public static int getGameNumber() {
        return gameNumber;
    }

    /**
     * @param aGameNumber the gameNumber to set
     */
    public static void setGameNumber(int aGameNumber) {
        gameNumber = aGameNumber;
    }

    /**
     * @return the Game
     */
    public String getGame() {
        return Game;
    }

    /**
     * @return the homeScore
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * @param homeScore the homeScore to set
     */
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    /**
     * @return the awayScore
     */
    public int getAwayScore() {
        return awayScore;
    }

    /**
     * @param awayScore the awayScore to set
     */
    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    /**
     * @return the higestTemp
     */
    public int getHigestTemp() {
        return higestTemp;
    }

    /**
     * @param higestTemp the higestTemp to set
     */
    public void setHigestTemp(int higestTemp) {
        this.higestTemp = higestTemp;
    }
// </editor-fold>

    private void scoreMaker(Team t1, Team t2) {
        Random rn = new Random();

        setHomeScore(rn.nextInt(10) * (sc.getTempInput() / 10));
        setAwayScore(rn.nextInt(10) * (sc.getTempInput() / 10));
        t1.setTotalGoal(t1.getTotalGoal() + getHomeScore());
        t2.setTotalgoalAllowed(t1.getTotalgoalAllowed() + getHomeScore());
        t1.setTotalgoalAllowed(t1.getTotalgoalAllowed() + getAwayScore());
        t2.setTotalGoal(t2.getTotalGoal() + getAwayScore());

        if (getHomeScore() == getAwayScore()) {
            t1.setTieNumber(t1.getTieNumber() + 1);
            t2.setTieNumber(t2.getTieNumber() + 1);

        } else if (getHomeScore() > getAwayScore()) {
            t1.setTotalWin(t1.getTotalWin() + 1);
            t2.setTotalLoss(t2.getTotalLoss() + 1);
        } else {
            t1.setTotalLoss(t1.getTotalLoss() + 1);
            t2.setTotalWin(t2.getTotalWin() + 1);
        }

    }

    public void tempCal() {
        if (sc.getTempInput() > getHigestTemp()) {
            setHigestTemp(sc.getTempInput());
        }
        int tempAverage = 0;
        tempAverage += sc.getTempInput();
        setAvTempSeason(tempAverage + gameRecord.size());
    }

    public void showTemp() {
        System.out.println("Higest Temperature of season: " + getHigestTemp() + "\\u00B0 C");
        System.out.println("Average Temperature of season: " + getAvTempSeason() + "\\u00B0 C");
    }
    public void showAll(){
        System.out.println(gameRecord);
    }

}
