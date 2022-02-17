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
public class Game {

    Random rn = new Random();
    private int gameCost;

    public Game() {
        gameCost = 5;
    }

    public Game(int cost) {
        this.gameCost = cost;
    }

    /**
     * @return the gameCost
     */
    public int getGameCost() {
        return gameCost;
    }

    public void play(Card c1) {
        c1.setCredit(c1.getCredit() - gameCost);
        c1.setTickets(c1.getTickets() + rn.nextInt(9));
    }

}
