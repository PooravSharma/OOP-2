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
        c1.setCredit(c1.getCredit() - amCredit);
        c2.setCredit(c2.getCredit() + amCredit);
    }

    /**
     * @param credit the credit to set
     */
    public void addCredit(Card c1, int credit) {
        c1.setCredit(c1.getCredit() + (credit * 2));
    }

    public void getPrize() {

    }

}
