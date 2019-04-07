package edu.gatech.cs2340.team49x.spacetrader.ViewObjects;

/**
 * Class for current player inventory in InfoActivity
 */
public class InvenItem {

    private final String name;
    private final int quantity;

    /**
     * Default Constructor
     * @param name name of an item
     * @param quantity quantity of an item
     */
    public InvenItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Gets item name
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets item quantity
     * @return quantity of an item in cargo
     */
    public int getQuantity() {
        return quantity;
    }
}