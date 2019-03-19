package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

public class InvenItem {

    private String name;
    private int quantity;

    public InvenItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}