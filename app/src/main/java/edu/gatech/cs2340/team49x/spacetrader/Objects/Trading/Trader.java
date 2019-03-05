package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.List;
import java.util.Map;

public interface Trader {
    Tradable[] sells();
    Tradable[] buys();
    int getPrice(Tradable t);
}
