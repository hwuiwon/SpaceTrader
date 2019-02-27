package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class TradeTransaction {
    private Player customer;
    private PriceList prices;
    private Inventory itemsToSell;
    private Inventory itemsToBuy;

    public TradeTransaction(Player customer, PriceList prices) {
        this.customer = customer;
        this.prices = prices;
        this.itemsToSell = new Inventory();
        this.itemsToBuy = new Inventory();
    }

    public void addItemToSell(TradeGood item, int quantity) {
        itemsToSell.add(item, quantity);
    }

    public void addItemToBuy(TradeGood item, int quantity) {
        itemsToBuy.add(item, quantity);
    }

    public Inventory getItemsToSell() {
        return itemsToSell;
    }

    public Inventory getItemsToBuy() {
        return itemsToBuy;
    }

    public int getTotalCost() {
        return itemsToBuy.getPrice(prices) - itemsToSell.getPrice(prices);
    }

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