package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Trader;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

/**
 * This class is used by MarketViewModel to connect with the backend.
 */
public class TradeInteractor {
    private Player customer;
    private Trader trader;

    public TradeInteractor(Player customer, Trader trader) {
        init(customer, trader);
    }

    public TradeInteractor(Player customer, SolarSystem system) {
        this(customer, system.getMarket());
    }

    public void init(Player customer, Trader trader) {
        this.customer = customer;
        this.trader = trader;
    }

    public void init(Player customer, SolarSystem system) {
        this.customer = customer;
        this.trader = system.getMarket();
    }

    public int getPriceOf(String good) {
        return trader.getPrice(good);
    }

    public int getCargoAmount(String good) {
        return customer.getAmountOf(good);
    }

    public int getCargoRemaining() {
        return customer.cargoSpaceRemaining();
    }

    public String[] getBuyList() {
        return trader.buys();
    }

    public String[] getSellList() {
        return trader.sells();
    }

    public void removeFromCargo(Inventory items) {
        customer.removeFromCargo(items);
    }

    public void addToCargo(Inventory items) {
        customer.addToCargo(items);
    }

    public void changeCredits(int change) {
        customer.changeCredits(change);
    }
}