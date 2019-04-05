package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class is used to represent a collection of Tradable and their quantities.
 */
public class Inventory implements Serializable {

    static final long serialVersionUID = 1L;
    private final Map<Tradable, Integer> quantities;
    private int count;

    /**
     * Creates an empty inventory
     */
    public Inventory() {
        quantities = new HashMap<>();
        count = 0;
    }

    /**
     * Adds the items from another inventory to this one.
     * @param inventory the items to add
     */
    public void add(Inventory inventory) {
        for (Tradable good : inventory.quantities.keySet()) {
            add(good, inventory.quantities.get(good));
        }
    }

    /**
     * Adds a quantity of goods to this inventory
     * @param good the good to add
     * @param quantity the quantity to add
     */
    public void add(Tradable good, int quantity) {
        if (quantities.containsKey(good)) {
            int result = quantities.get(good) + quantity;
            if (result != 0) {
                quantities.put(good, result);
            } else {
                quantities.remove(good);
            }
        } else if (quantity != 0) {
            quantities.put(good, quantity);
        }

        count += quantity;
    }

    /**
     * Removes the items of another inventory from this one.
     * @param inventory the items to remove
     */
    public void remove(Inventory inventory) {
        for (Tradable good : inventory.quantities.keySet()) {
            add(good, -inventory.quantities.get(good));
        }
    }

    /**
     * Returns the quantity of a good in this inventory
     * @param good the good to test for
     * @return the quantity of the good
     */
    public int getQuantity(Tradable good) {
        if (quantities.containsKey(good)) {
            return quantities.get(good);
        }
        return 0;
    }

    /**
     * Returns the set of Tradables that this inventory contains at least one of.
     * @return keySet of quantities
     */
    public Set<Tradable> getItemSet() {
        return quantities.keySet();
    }

    /**
     * Empties the inventory.
     */
    public void empty() {
        quantities.clear();
        count = 0;
    }

    /**
     * @return the number of items in this inventory
     */
    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "quantities=" + quantities +
                ", count=" + count +
                '}';
    }
}