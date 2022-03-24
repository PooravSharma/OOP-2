package soccergame;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 30045900
 */
public class SoccerGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Team team1 = new Team();
        Team team2 = new Team("hey");
        Team team3 = new Team();
        Team team4 = new Team("yo");
        Team[] teams = new Team[]{team1, team2, team3, team4};

        Scheduler scheduler = new Scheduler();

        while (scheduler.getColdWeeks() < 3) {
            System.out.print("Enter today's temperature: ");
            try {
                Scanner sn = new Scanner(System.in);
                scheduler.setTempInput(sn.nextInt());

            } catch (Exception ex) {
                System.out.println("!!!!ERROR!!!!\nPlease enter correct temperature");
                sc.next();
            }
            scheduler.coldweeks();
            if (scheduler.getTempInput() >= 10) {
                scheduler.scheduleGame(teams);

            } else {

                System.out.println("Too cold to play!!\n");
            }
        }
        System.out.println("Winter is here!!\n");
        try {
            System.out.println("*************TEAM RESULTS**************\"\n");
            System.out.println(Arrays.toString(teams));
            System.out.println("*************GAME RESULTS**************\"\n");
            scheduler.show();
        } catch (Exception ex) {
            System.out.println("No game was played");
        }

    }

}
