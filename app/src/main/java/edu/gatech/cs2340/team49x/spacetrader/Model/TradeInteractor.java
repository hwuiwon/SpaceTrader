package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Trader;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

/**
 * This class is used by MarketViewModel to connect with the backend.
 */
public class TradeInteractor {

    private Player customer;
    private Trader trader;

    /**
     * Initializes interactor
     * @param customer current player
     * @param trader trader used for trade
     */
    private void init(Player customer, Trader trader) {
        this.customer = customer;
        this.trader = trader;
    }

    /**
     * Initializes interactor
     * @param customer current player
     * @param system current SolarSystem
     */
    public void init(Player customer, SolarSystem system) {
        init(customer, system.getMarket());
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
     * Gets item amount in cargo
     * @param good selected item
     * @return number of items that player owns
     */
    public int getCargoAmount(Tradable good) {
        return customer.getAmountOf(good);
    }

    /**
     * Gets remaining space
     * @return remaining space of a ship
     */
    public int getCargoRemaining() {
        return customer.cargoSpaceRemaining();
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

    /**
     * Removes item from cargo
     * @param items selected item
     */
    public void removeFromCargo(Inventory items) {
        customer.removeFromCargo(items);
    }

    /**
     * Adds item to cargo
     * @param items selected item
     */
    public void addToCargo(Inventory items) {
        customer.addToCargo(items);
    }

    /**
     * Changes player credit
     * @param change amount that will be changed
     */
    public void changeCredits(int change) {
        customer.changeCredits(change);
    }

    /**
     * Get credits
     * @return credits that player owns
     */
    public int getCredits() {
        return customer.getCredits();
    }
}