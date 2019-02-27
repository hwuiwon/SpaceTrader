package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Map;

/**
 * This class is used to represent a collection of TradeGoods and their quantities.
 */
public class Inventory {
    private Map<TradeGood, Integer> quantities;

    public int getPrice(PriceList pl) {
        int total = 0;
        for (Map.Entry<TradeGood, Integer> item : quantities.entrySet()) {
            total += pl.priceOf(item.getKey()) * item.getValue();
        }
        return total;
    }

    public void add(Inventory inventory) {
        for (TradeGood good : inventory.quantities.keySet()) {
            if (this.quantities.containsKey(good)) {
                this.quantities.put(good, inventory.quantities.get(good) + this.quantities.get(good));
            } else {
                this.quantities.put(good, inventory.quantities.get(good));
            }
        }
    }
}
