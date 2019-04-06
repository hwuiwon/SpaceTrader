package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Trader;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

/**
 * This class is used by MarketViewModel to connect with the backend.
 */
public class TradeInteractor {

    // --Commented out by Inspection (4/6/2019 5:57 AM):private Player customer;
    private Trader trader;

    /**
     * Initializes interactor
     * @param trader trader used for trade
     */
    private void init(Trader trader) {
        this.trader = trader;
    }

    /**
     * Initializes interactor
     * @param system current SolarSystem
     */
    public void init(SolarSystem system) {
        init(system.getMarket());
    }

    /**
     * Gets price of item
     * @param good selected item
     * @return price of a selected item
     */
    public int getPriceOf(Tradable good) {
        return trader.getPrice(good);
    }

    /**
     * Gets list of purchasable items
     * @return list of items
     */
    public Tradable[] getBuyList() {
        return trader.buys();
    }

    /**
     * Gets list of sellable items
     * @return list of items
     */
    public Tradable[] getSellList() {
        return trader.sells();
    }


}