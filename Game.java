/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccergame;

/**
 *
 * @author 30045900
 */
public class Game {
    private int tempDay;
    private double avTempSeason;
    int gameNumber = 1; 
    Team team1, team2;
    private static Game[] gameRecord;
    
    public Game(Team inTeam1, Team inTeam2, Scheduler sc){
        tempDay =sc.getTempInput();
        team1 = inTeam1;
        team2 = inTeam2;
        
    }

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
    
    public void gameStats(){
       
    }
   
   
}
