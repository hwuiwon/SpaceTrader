package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Item {

    private String name;
    private int price;
    private int remaining;
    private int quantity;

    public Item(String name, int price, int remaining) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRemaining() {
        return remaining;
    }

    public void addQuantity() {
        quantity++;
    }

    public void removeQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    public int getQuantity() {
        return quantity;
    }
}