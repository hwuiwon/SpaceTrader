package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class TradeTransaction {
    private Player customer;
    private PriceList prices;
    private Inventory itemsToSell;
    private Inventory itemsToBuy;

    public void addItemToSell(TradeGood item, int quantity) {
        itemsToSell.add(item, quantity);
    }

    public void addItemToBuy(TradeGood item, int quantity) {
        itemsToBuy.add(item, quantity);
    }

    public int getTotalCost() {
        return itemsToBuy.getPrice(prices) - itemsToSell.getPrice(prices);
    }
}