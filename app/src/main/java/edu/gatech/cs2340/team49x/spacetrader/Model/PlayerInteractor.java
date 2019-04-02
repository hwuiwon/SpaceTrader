package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class PlayerInteractor {

    private Player player;
    private Ship ship;

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
     * Gets player
     * @return current player
     */
    public Player getPlayer() {
        return player;
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
}