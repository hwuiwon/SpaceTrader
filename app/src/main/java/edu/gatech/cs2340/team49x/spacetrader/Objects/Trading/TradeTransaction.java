package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Map;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;

public class TradeTransaction {
    private Player customer;
    private Map<Tradable, Integer> prices;
    private Inventory itemsToSell;
    private Inventory itemsToBuy;

    /**
     * Creates a transaction
     * @param customer the customer of the transaction
     * @param prices the price list of items for this transaction
     */
    public TradeTransaction(Player customer, Map<Tradable, Integer> prices) {
        this.customer = customer;
        this.prices = prices;
        this.itemsToSell = new Inventory();
        this.itemsToBuy = new Inventory();
    }

    public Player getCustomer() {
        return customer;
    }

    public Map<Tradable, Integer> getPrices() {
        return prices;
    }

    /**
     * Adds items to sell
     * @param item the good to add
     * @param quantity the quantity to add
     */
    public void addItemToSell(Tradable item, int quantity) {
        itemsToSell.add(item, quantity);
    }

     /**
     * Adds items to sell buy
     * @param item the good to add
     * @param quantity the quantity to add
     */
    public void addItemToBuy(Tradable item, int quantity) {
        itemsToBuy.add(item, quantity);
    }

    /**
     * @return items to sell
     */
    public Inventory getItemsToSell() {
        return itemsToSell;
    }

    /**
     * @return items to buy
     */
    public Inventory getItemsToBuy() {
        return itemsToBuy;
    }

    /**
     * @return the total cost of items bought
     */
    public int getTotalCost() {
        return itemsToBuy.getPrice(prices);
    }

    /**
     * @return the total cost of items sold
     */
    public int getTotalSale() {
        return itemsToSell.getPrice(prices);
    }

    /**
     * Makes the transaction, if possible
     * @return true if the transaction was successful, false otherwise
     */
    public boolean makeTrade() {
        if (customer.getCredits() >= getTotalCost()
                && customer.has(itemsToSell)
                && customer.cargoSpaceRemaining() >= itemsToBuy.getCount()) {
            customer.removeFromCargo(itemsToSell);
            customer.addToCargo(itemsToBuy);
            customer.changeCredits(-getTotalCost());
            itemsToSell.empty();
            itemsToBuy.empty();
            return true;
        }
        return false;
    }
}