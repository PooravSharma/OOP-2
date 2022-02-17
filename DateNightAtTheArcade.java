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
        Terminal t1 = new Terminal();

        System.out.println(c1.getCredit());

        t1.addCredit(c1, 20);
        System.out.println(c1.getCredit());

        t1.transferCredit(c1, c2);
        System.out.println(c1.getCredit());
        System.out.println(c2.getCredit());
    }

}
