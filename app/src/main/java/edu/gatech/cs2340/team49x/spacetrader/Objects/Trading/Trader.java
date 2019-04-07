package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.io.Serializable;

/**
 * Object used for trade
 */
public interface Trader extends Serializable {

    /**
     * @return list of sellable items
     */
    Tradable[] sells();

    /**
     * @return list of purchasable items
     */
    Tradable[] buys();

    /**
     * @param tradable item
     * @return price of an item
     */
    int getPrice(Tradable tradable);
}