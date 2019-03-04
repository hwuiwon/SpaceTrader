package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.Map;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeTransaction;

/**
 * This class is used by MarketViewModel to connect with the backend.
 */
public class TradeInteractor {
    private TradeTransaction trade;
    private Map<Tradable, Integer> prices;
    private Player customer;

    public TradeInteractor(TradeTransaction trade) {
        this.trade = trade;
        this.prices = trade.getPrices();
        this.customer = trade.getCustomer();
    }

    public int getPriceOf(Tradable good) {
        return prices.get(good);
    }

    public int getCargoAmount(Tradable good) {
        return customer.getAmountOf(good);
    }

    /**
     * Adds items to sell
     * @param item the good to add
     * @param quantity the quantity to add
     */
    public void addItemToSell(Tradable item, int quantity) {
        trade.addItemToBuy(item, quantity);
    }

    /**
     * Adds items to buy
     * @param item the good to add
     * @param quantity the quantity to add
     */
    public void addItemToBuy(Tradable item, int quantity) {
        trade.addItemToSell(item, quantity);
    }

    public void makeTrade() {
        trade.makeTrade();
    }
}
