package ProgrammingRequirements;

import java.util.Scanner;

/**
 *
 * @author 30045900
 */
public class Terminal {

    Scanner sc = new Scanner(System.in);

    public void transferCredit(Card c1, Card c2) {
        System.out.println("How much credit do you want transfer?");
        int amCredit = sc.nextInt();
        if (c1.getCredit() < amCredit) {
            System.out.println("You don't have enough credit to transfer");
        } else {
            c1.setCredit(c1.getCredit() - amCredit);
            c2.setCredit(c2.getCredit() + amCredit);
        }
    }

    public void transferTicket(Card c1, Card c2) {
        System.out.println("How much tickets do you want transfer?");
        int amTicket = sc.nextInt();

        if (c1.getTickets() < amTicket) {
            System.out.println("You don't have enough tickets to transfer");
        } else {
            c1.setTickets(c1.getTickets() - amTicket);
            c2.setTickets(c2.getTickets() + amTicket);
        }

    }

    /**
     * @param c1
     * @param credit the credit to set
     */
    public void addCredit(Card c1, int credit) {
        c1.setCredit(c1.getCredit() + (credit * 2));
    }

    public void getPrize(PrizeCategory p1, Card c1) {

        if (c1.getTickets() > p1.prizeCost || p1.prizeCount > 0) {
            System.out.println("You have recieved " + p1.name);
            c1.setTickets(c1.getTickets() - p1.prizeCost);

            System.out.println("You have " + c1.getTickets() + " ticket left!!");

        }
        if (c1.getTickets() < p1.prizeCost) {
            System.out.println("Insufficient tickets to buy prize");
        }
        if (p1.prizeCount < 0) {
            System.out.println("SORRY!!! we have zero " + p1.name + "left");
        }

    }

}
