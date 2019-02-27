package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to represent a collection of TradeGoods and their quantities.
 */
public class Inventory {
    private Map<TradeGood, Integer> quantities;
    private int count;

    public Inventory() {
        quantities = new HashMap<>();
        count = 0;
    }

    public int getPrice(PriceList pl) {
        int total = 0;
        for (Map.Entry<TradeGood, Integer> item : quantities.entrySet()) {
            total += pl.priceOf(item.getKey()) * item.getValue();
        }
        return total;
    }

    public void add(Inventory inventory) {
        for (TradeGood good : inventory.quantities.keySet()) {
            add(good, quantities.get(good));
        }
    }

    public void remove(Inventory inventory) {
        for (TradeGood good : inventory.quantities.keySet()) {
            add(good, -quantities.get(good));
        }
    }

    /**
     * Returns true if this inventory as at least a certain quantity of a good.
     *
     * @param good the TradeGood to test.
     * @param quantity the amount the inventory must contain.
     * @return
     */
    public boolean has(TradeGood good, int quantity) {
        if (quantities.containsKey(good)) {
            return quantity <= quantities.get(good);
        }
        return quantity <= 0;
    }

    public void add(TradeGood good, int quantity) {
        if (quantities.containsKey(good)) {
            quantities.put(good, quantities.get(good) + quantity);
        } else {
            quantities.put(good, quantity);
        }
        count += quantity;
    }

    public int getQuantity(TradeGood good) {
        return quantities.get(good);
    }

    public int getCount() {
        return count;
    }
}
