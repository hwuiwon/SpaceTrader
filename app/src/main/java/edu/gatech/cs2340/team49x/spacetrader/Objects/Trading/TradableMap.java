package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.HashMap;
import java.util.Map;

/**
 * Holds a map of Tradables keyed by name
 */
public class TradableMap {
    private final Map<String, Tradable> map;

    /**
     * Make a new TradableMap
     */
    public TradableMap() {
        map = new HashMap<>();
        for (TradeGood good : TradeGood.values()) {
            map.put(good.getName(), good);
        }
    }

    /**
     * Get the Tradable with this name
     * @param name the name of the Tradable
     * @return the Tradable object
     */
    public Tradable getTradable(String name) {
        return map.get(name);
    }
}
