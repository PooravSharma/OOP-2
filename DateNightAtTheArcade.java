/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datenightatthearcade;

import ProgrammingRequirements.*;

/**
 *
 * @author 30045900
 */
public class DateNightAtTheArcade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Card c1 = new Card();
        Card c2 = new Card(3045945);
        Card c3 = new Card();
        Terminal t1 = new Terminal();
        Game game1 = new Game();
        Game game2 = new Game(1);

         System.out.println(c1. getCardNo());
          System.out.println(c2. getCardNo());
          System.out.println(c3. getCardNo());
          
        System.out.println(c1.getCredit());

        t1.addCredit(c1, 20);
        System.out.println(c1.getCredit());

        t1.transferCredit(c1, c2);
        System.out.println("Card #1 Credit = " + c1.getCredit());
        System.out.println("Card #2 Credit = " + c2.getCredit());

        for (int i = 0; i <= 4; i++) {
            System.out.println("###Play game#1 with card #1");
            game1.play(c1);
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println("###Play game#2 with card #2");
            game2.play(c2);
        }

        t1.transferTicket(c1, c2);
        System.out.println("Card #1 Tickets = " + c1.getTickets());
        System.out.println("Card #2 Tickets = " + c2.getTickets());

    }

}
