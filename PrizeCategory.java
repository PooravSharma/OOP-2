/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProgrammingRequirements;

/**
 *
 * @author 30045900
 */
public class PrizeCategory {

    private int prizeCost;
    private String name;
    private int prizeCount;

    public PrizeCategory(String inName, int coTicket, int pNumber) {
        prizeCost = coTicket;
        name = inName;
        prizeCount = pNumber;
    }

    /**
     * @param prizeCount the prizeCount to set
     */
    public void setPrizeCount(int prizeCount) {
        this.prizeCount = prizeCount;
    }

    /**
     * @return the prizeCount
     */
    public int getPrizeCount() {
        return prizeCount;
    }

    /**
     * @return the prizeCost
     */
    public int getPrizeCost() {
        return prizeCost;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
