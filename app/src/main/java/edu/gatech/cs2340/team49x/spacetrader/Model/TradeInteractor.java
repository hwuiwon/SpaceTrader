package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.Map;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.TechLevel;

/**
 * This class is used by MarketViewModel to connect with the backend.
 */
public class TradeInteractor {
    private Player customer;
    private Map<Tradable, Integer> prices;

    public TradeInteractor(Player customer, Map<Tradable, Integer> prices) {
        this.customer = customer;
        this.prices = prices;
    }

    public TradeInteractor(Player customer, SolarSystem system) {
        this(customer, system.getPrices());
    }

    public int getPriceOf(Tradable good) {
        return prices.get(good);
    }

    public int getCargoAmount(Tradable good) {
        return customer.getAmountOf(good);
    }

    public void removeFromCargo(Tradable good, int quantity) {
        customer.removeFromCargo(good, quantity);
    }

    public void addToCargo(Tradable good, int quantity) {
        customer.addToCargo(good, quantity);
    }

    public void changeCredits(int change) {
        customer.changeCredits(change);
    }
}
