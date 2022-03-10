/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccergame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 30045900
 */
public class Scheduler {

    Exception exception = new Exception();
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();
    public int tempInput;
    Game game;
    private int coldWeeks = 0;

//    public void getTemp(Team[] teams) {
//        while (coldWeeks < 3) {
//            System.out.print("Enter today's temperature: ");
//            try {
//                Scanner sn = new Scanner(System.in);
//                tempInput = sn.nextInt();
//
//            } catch (Exception ex) {
//                System.out.println("!!!!ERROR!!!!\nPlease enter correct temperature");
//                sc.next();
//            }
//            if (tempInput >= 10) {
//                scheduleGame(teams);
//                game.tempCal();
//                
//            }
//            else{
//                coldweeks();
//            }
//        }
//        System.out.println(game);
//        System.out.println(teams);
//        game.showTemp();
//    }

    public int coldweeks() {
        if (getTempInput() < 10) {
            coldWeeks++;
        } else if (getTempInput() >= 10) {
            coldWeeks = 0;
        }

        return coldWeeks;
    }

    public void scheduleGame(Team[] teams) {

        int tOne, tTwo, tThree, tFour;
        tOne = rn.nextInt(4);
        tTwo = 0;
        tThree = 0;
        tFour = 0;
       
        for (int i = 0; i < 4; i++) {
            if (tOne != i) {
                tTwo = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (tTwo != i && tOne != i) {
                tThree = i;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (tTwo != i && tThree != i && tOne != i) {
                tFour = i;
            }
        }
        Game game1 = new Game(teams[tOne], teams[tTwo]);
        Game game2 = new Game(teams[tThree], teams[tFour]);

        System.out.println("2 Games scheduled. (1 game for 2 teams)");
        System.out.println(teams[tOne].getTeamName() + " vs " + teams[tTwo].getTeamName());
        System.out.println(teams[tThree].getTeamName() + " vs " + teams[tFour].getTeamName());
    }

    /**
     * @return the tempInput
     */
    public int getTempInput() {
        return tempInput;
    }

}
