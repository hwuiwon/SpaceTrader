package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

public interface Trader {

    Tradable[] sells();
    Tradable[] buys();
    int getPrice(Tradable t);
}