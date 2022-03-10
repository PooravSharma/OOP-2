package soccergame;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 30045900
 */
public class SoccerGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Team team1 = new Team();
        Team team2 = new Team("hey");
        Team team3 = new Team();
        Team team4 = new Team("yo");
        Team[] teams = new Team[]{team1, team2, team3, team4};
        Game g = new Game(team1, team2);
        Scheduler scheduler = new Scheduler();

        while (scheduler.coldweeks() < 3) {
            System.out.print("Enter today's temperature: ");
            try {
                Scanner sn = new Scanner(System.in);
                scheduler.tempInput = sn.nextInt();

            } catch (Exception ex) {
                System.out.println("!!!!ERROR!!!!\nPlease enter correct temperature");
                sc.next();
            }
            if (scheduler.tempInput >= 10) {
                scheduler.scheduleGame(teams);
                g.tempCal();

            } else {
                scheduler.coldweeks();
            }
        }

        g.showAll();
        System.out.println(teams);
        g.showTemp();

    }
    //scheduler.getTemp(teams); 

//        System.out.println("*************RESULTS**************");
//        System.out.println("Team: " + team1.getTeamName());
//        System.out.println("Total WIns: " + team1.getTotalWin());
//        System.out.println("Total Losses: " + team1.getTotalLoss());
//        System.out.println("Total Ties: " + team1.getTieNumber());
//        System.out.print("Total points scored: " + team1.getTotalGoal());
//        System.out.print("  Total points allowed: " + team1.getTotalgoalAllowed() + "\n");
}


