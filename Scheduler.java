/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccergame;

import java.util.Scanner;

/**
 *
 * @author 30045900
 */
public class Scheduler {

    Exception exception = new Exception();
    Scanner sc = new Scanner(System.in);
    public int tempInput;

    private int coldWeeks = 0;

    public void getTemp() {
        while (coldWeeks < 3) {
            System.out.print("Enter today's temperature: ");
            try {
                Scanner sc = new Scanner(System.in);
                tempInput = sc.nextInt();

            } catch (Exception ex) {
                System.out.println("!!!!ERROR!!!!\nPlease enter correct temperature");
            }
            System.out.println("ly");
            coldweeks();
        }

        System.out.println("loop ended");
    }

    public int coldweeks() {
        if (getTempInput() < 10) {
            coldWeeks++;
        } else if (getTempInput() >= 10) {
            coldWeeks = 0;
        }

        return coldWeeks;
    }
    public void scheduleGame(Team t1, Team t2){
        System.out.print("2 Games Scheduled. (1 game for 2 teams)");   
        
    }

    /**
     * @return the tempInput
     */
    public int getTempInput() {
        return tempInput;
    }
    
}
