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
    private static String Game = "";
    private String GameID;
    private static int gameNumber = 1, tempAverage;
    Team team1, team2;
    private int homeScore;
    private int awayScore;
    private static int higestTemp = 0;
    private static ArrayList<Game> gameRecord = new ArrayList<>();

    public Game(Team t1, Team t2, int temp) {
        tempDay = temp;
        team1 = t1;
        team2 = t2;
        tempCal();
        scoreMaker(t1, t2);
        GameID = "Game #" + getGameNumber();
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

    public String outString() {
        for (Game game : gameRecord) {
            Game = Game + "\n" + game.GameID
                    + "\nTemperature: " + game.getTempDay()
                    + "\n" + game.team1.getTeamName() + " goal score: " + game.getHomeScore()
                    + "\n" + game.team2.getTeamName() + " goal score: " + game.getAwayScore() + "\n";
        }
        return Game;
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
    public void setHomeScore(int inHomeScore) {
        homeScore = inHomeScore;
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
    public void setAwayScore(int inAwayScore) {
        awayScore = inAwayScore;
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
    public void setHigestTemp(int inHigestTemp) {
        higestTemp = inHigestTemp;
    }
// </editor-fold>

    private void scoreMaker(Team t1, Team t2) {
        Random rn = new Random();

        setHomeScore(rn.nextInt(10) * (tempDay / 10));
        setAwayScore(rn.nextInt(10) * (tempDay / 10));
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

        if (tempDay > higestTemp) {
            setHigestTemp(tempDay);
        }
        tempAverage += tempDay;
        setAvTempSeason(tempAverage / (gameNumber * 1.0));
    }

    public void showTemp() {
        System.out.println("Higest Temperature of season: " + getHigestTemp() + "\u00B0C");
        System.out.println("Average Temperature of season: " + getAvTempSeason() + "\u00B0C");
    }

}
