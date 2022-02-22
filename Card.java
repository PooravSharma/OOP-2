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
    private static int noCards = 1;
    public Card() {
        this.cardNo = noCards;
        noCards++;
    }

    public Card(int incardNo) {
        cardNo = incardNo;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int incredit) {
        credit = incredit;
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
    public void setTickets(int intickets) {
        tickets = intickets;
    }

    /**
     * @return the cardNo
     */
    public int getCardNo() {
        return cardNo;
    }

    /**
     * @return the noCards
     */
    public static int getNoCards() {
        return noCards;
    }

    /**
     * @param aNoCards the noCards to set
     */
    public static void setNoCards(int aNoCards) {
        noCards = aNoCards;
    }

}
