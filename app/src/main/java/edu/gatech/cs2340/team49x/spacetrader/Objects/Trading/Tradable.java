package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.io.Serializable;

/**
 * Interface for TradeGood
 */
public interface Tradable extends Serializable {

    /**
     * @return name of an item
     */
    String getName();
}