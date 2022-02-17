/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgrammingRequirements;

import java.util.Random;

/**
 *
 * @author 30045900
 */
public class Card {

    Random rn = new Random();
    private int cardNo;
    private int credit;
    private int tickets;

    public Card() {
        cardNo = rn.nextInt(99999999);
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Card(int cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * @return the tickets
     */
    public int getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

}
