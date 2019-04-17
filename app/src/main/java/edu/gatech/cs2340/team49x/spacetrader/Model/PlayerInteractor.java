package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

/**
 * This class is used by InfoViewModel, MarketViewModel, and TravelViewModel
 * to connect with the backend.
 */
public class PlayerInteractor {

    private Player player;
    private Ship ship;
    final double PILOT_RATIO = 0.1;
    final double TRADE_RATIO = 0.01;

    /**
     * Initialize PlayerInteractor
     * @param player current player
     */
    public void init(Player player) {
        this.player = player;
        this.ship = player.getShip();
    }

    /**
     * Gets name
     * @return name of a player
     */
    public String getName() {
        return player.getName();
    }

    /**
     * Gets fuel
     * @return remaining fuel
     */
    public int getFuel() {
        return ship.getFuel();
    }

    /**
     * Gets fuel required to travel a certain distance
     * @param distance distance to travel
     * @return fuel required
     */
    public double getFuelRequired(double distance) {
        return ship.fuelRequiredToTravel(distance);
    }

    /**
     * Gets speed
     * @return speed of a ship
     */
    public int getSpeed() {
        return ship.getSpeed();
    }

    /**
     * Gets max travel distance
     * @return remaining distance that ship can travel with remaining fuel
     */
    public double getMaxTravelDistance() {
        return ship.getMaxTravelDistance();
    }

    /**
     * Decreases fuel
     * @param distance distance that player traveled
     */
    public void decreaseFuel(double distance) {
        ship.useFuel(distance);
    }

    /**
     * Gets inventory set
     * @return set of inventory
     */
    public Set<Tradable> getInventorySet() {
        return ship.getCargoSet();
    }

    /**
     * Gets amount of item
     * @param good selected item
     * @return number of items player currently owns
     */
    public int amountOf(Tradable good) {
        return ship.getAmountOf(good);
    }

    /**
     * Removes item from cargo
     * @param items selected item
     */
    public void removeFromCargo(Inventory items) {
        ship.removeFromCargo(items);
    }

    /**
     * Adds item to cargo
     * @param items selected item
     */
    public void addToCargo(Inventory items) {
        ship.addToCargo(items);
    }

    /**
     * Changes player credit
     * @param change amount that will be changed
     */
    public void changeCredits(int change) {
        player.changeCredits(change);
    }

    /**
     * Get credits
     * @return credits that player owns
     */
    public int getCredits() {
        return player.getCredits();
    }

    /**
     * Gets item amount in cargo
     * @param good selected item
     * @return number of items that player owns
     */
    public int getCargoAmount(Tradable good) {
        return ship.getAmountOf(good);
    }

    /**
     * Gets remaining space
     * @return remaining space of a ship
     */
    public int getCargoRemaining() {
        return ship.cargoSpaceRemaining();
    }

    /**
     * Gets pilot points
     * @return pilot points of player
     */
    public double getPilotPt() {
        return player.getPilotPt() * PILOT_RATIO;
    }

    /**
     * Gets trader points
     * @return trader points of player
     */
    public double getTradePt() {
        return 1 - player.getTradePt() * TRADE_RATIO;
    }
}