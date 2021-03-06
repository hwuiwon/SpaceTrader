package edu.gatech.cs2340.team49x.spacetrader.ViewObjects;

/**
 * Items sold in market
 */
public class Item {

    private final String good;
    private final int price;
    private int remaining;

    /**
     * Default Constructor
     * @param good item
     * @param price price of an item
     * @param remaining remaining number of item
     */
    public Item(String good, int price, int remaining) {
        this.good = good;
        this.price = price;
        this.remaining = remaining;
    }

    /**
     * Gets name
     * @return name of a player
     */
    public String getName() {
        return good;
    }

    /**
     * Gets item price
     * @return price of an item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets count of remaining items
     * @return number of remaining items
     */
    public int getRemaining() {
        return remaining;
    }

    /**
     * Set remaining quantity of an item
     * @param remaining quantity that will replace current quantity
     */
    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}