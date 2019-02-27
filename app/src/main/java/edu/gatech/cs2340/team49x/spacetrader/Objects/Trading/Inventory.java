package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to represent a collection of TradeGoods and their quantities.
 */
public class Inventory {
    private Map<TradeGood, Integer> quantities;
    private int count;

    /**
     * Creates an empty inventory
     */
    public Inventory() {
        quantities = new HashMap<>();
        count = 0;
    }

    /**
     * Returns the price of this inventory given a PriceList.
     * @param pl the PriceList to use for computing prices
     * @return the price of this inventory
     */
    public int getPrice(PriceList pl) {
        int total = 0;
        for (Map.Entry<TradeGood, Integer> item : quantities.entrySet()) {
            total += pl.priceOf(item.getKey()) * item.getValue();
        }
        return total;
    }

    /**
     * Adds the items from another inventory to this one.
     * @param inventory the items to add
     */
    public void add(Inventory inventory) {
        for (TradeGood good : inventory.quantities.keySet()) {
            add(good, quantities.get(good));
        }
    }

    /**
     * Removes the items of another inventory from this one.
     * @param inventory the items to remove
     */
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

    /**
     * Tests if this inventory contains another as a subset.
     * @param inventory the items to test for
     * @return true if this inventory contains the given items
     */
    public boolean has(Inventory inventory) {
        for (TradeGood good : inventory.quantities.keySet()) {
            if (!has(good, inventory.quantities.get(good))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a quantity of goods to this inventory
     * @param good the good to add
     * @param quantity the quantity to add
     */
    public void add(TradeGood good, int quantity) {
        if (quantities.containsKey(good)) {
            quantities.put(good, quantities.get(good) + quantity);
        } else {
            quantities.put(good, quantity);
        }
        count += quantity;
    }

    /**
     * Returns the quantity of a good in this inventory
     *
     * @param good the good to test for
     * @return the quantity of the good
     */
    public int getQuantity(TradeGood good) {
        if (quantities.containsKey(good)) {
            return quantities.get(good);
        }
        return 0;
    }

    /**
     * Empties the inventory.
     */
    public void empty() {
        quantities = new HashMap<>();
        count = 0;
    }

    /**
     * @return the number of items in this inventory
     */
    public int getCount() {
        return count;
    }
}
