package edu.gatech.cs2340.team49x.spacetrader.Objects;

import android.graphics.Bitmap;

public class Item {

    private String name;
    private double price;
    private int remaining;
    private Bitmap itemPic;

    public Item(String name, double price, int remaining, Bitmap itemPic) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.itemPic = itemPic;
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

    public Bitmap getItemPic() {
        return itemPic;
    }
}