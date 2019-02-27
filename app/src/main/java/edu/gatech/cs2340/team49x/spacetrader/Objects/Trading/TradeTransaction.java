package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class TradeTransaction {
    private Player customer;
    private PriceList prices;
    private Inventory itemsToSell;
    private Inventory itemsToBuy;

    /**
     * Creates a transaction
     * @param customer the customer of the transaction
     * @param prices the PriceList of items for this transaction
     */
    public TradeTransaction(Player customer, PriceList prices) {
        this.customer = customer;
        this.prices = prices;
        this.itemsToSell = new Inventory();
        this.itemsToBuy = new Inventory();
    }

    /**
     * Adds items to sell
     * @param item the good to add
     * @param quantity the quantity to add
     */
    public void addItemToSell(TradeGood item, int quantity) {
        itemsToSell.add(item, quantity);
    }

     /**
     * Adds items to sell buy
     * @param item the good to add
     * @param quantity the quantity to add
     */
    public void addItemToBuy(TradeGood item, int quantity) {
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
     * @return the total cost of items bought minus items sold
     */
    public int getTotalCost() {
        return itemsToBuy.getPrice(prices) - itemsToSell.getPrice(prices);
    }

    /**
     * Makes the transaction, if possible
     * @return true if the transaction was successful, false otherwise
     */
    public boolean makeTrade() {
        if (customer.getCredits() >= getTotalCost()
                && customer.has(itemsToSell)
                && customer.cargoSpaceRemaining() >= itemsToBuy.getCount()){
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