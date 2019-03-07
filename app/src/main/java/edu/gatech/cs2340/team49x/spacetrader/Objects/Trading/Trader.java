package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

public interface Trader {
    String[] sells();
    String[] buys();
    int getPrice(String t);
}