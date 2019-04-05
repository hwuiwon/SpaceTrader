package edu.gatech.cs2340.team49x.spacetrader.ViewObjects;

public class InvenItem {

    final private String name;
    final private int quantity;

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