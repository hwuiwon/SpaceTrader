package edu.gatech.cs2340.team49x.spacetrader.Objects;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class Item {

    private Tradable good;
    private int price;
    private int remaining;

    public Item(Tradable good, int price, int remaining) {
        this.good = good;
        this.price = price;
        this.remaining = remaining;
    }

    public String getName() {
        return good.getName();
    }

    public int getPrice() {
        return price;
    }

    public int getRemaining() {
        return remaining;
    }

    public void copyData(Item other) {
        this.good = other.good;
        this.price = other.price;
        this.remaining = other.remaining;
    }

    public Tradable getGood() {
        return good;
    }
}