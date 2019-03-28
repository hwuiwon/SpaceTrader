package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.io.Serializable;

public interface Trader extends Serializable {
    Tradable[] sells();
    Tradable[] buys();
    int getPrice(Tradable t);
}