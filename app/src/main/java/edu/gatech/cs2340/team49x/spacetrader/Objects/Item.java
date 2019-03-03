package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Item {

    private String name;
    private double price;
    private int remaining;

    public Item(String name, double price, int remaining) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getRemaining() {
        return remaining;
    }
}