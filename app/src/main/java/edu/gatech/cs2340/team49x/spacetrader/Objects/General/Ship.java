package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import android.util.Log;

import java.io.Serializable;
import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

/**
 * Ship object
 */
public class Ship implements Serializable {

    static final long serialVersionUID = 1L;

    public enum ShipType {

        GNAT();

        private final int storage;
        private final int speed;
        private final int maxFuel;

        ShipType() {
            this.storage = 5;
            this.speed = 20000;
            this.maxFuel = 500000;
        }

        int getStorage() {
            return storage;
        }

        int getSpeed() {
            return speed;
        }

        int getMaxFuel() {
            return maxFuel;
        }
    }

    private final ShipType type;
    private final Inventory cargo;
    private int fuel;

    /**
     * Default constructor
     * @param type type of ship
     */
    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Inventory();
        this.fuel = type.getMaxFuel();
    }

    /**
     * Gets cargo
     * @return items in cargo
     */
    public Set<Tradable> getCargoSet() {
        return cargo.getItemSet();
    }

    /**
     * Gets fuel
     * @return remaining fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * Adds to cargo
     * @param items items that will be added in cargo
     */
    public void addToCargo(Inventory items) {
        cargo.add(items);
    }

    /**
     * Removes from cargo
     * @param items items that will get removed from cargo
     */
    public void removeFromCargo(Inventory items) {
        cargo.remove(items);
    }

    /**
     * Gets amount of item
     * @param good selected item
     * @return number of item in cargo
     */
    public int getAmountOf(Tradable good) {
        return cargo.getQuantity(good);
    }

    /**
     * Gets remaining cargo space
     * @return left space in cargo
     */
    public int cargoSpaceRemaining() {
        return type.getStorage() - cargo.getCount();
    }

    /**
     * Gets ship type
     * @return name of ship type
     */
    public String getName() {
        return type.name();
    }

    /**
     * Gets speed of ship
     * @return ship speed
     */
    public int getSpeed() {
        return type.getSpeed();
    }

    /**
     * Calculates fuel needed to travel distance
     * @param distance distance
     * @return fuel needed
     */
    public double fuelRequiredToTravel(double distance) {
        return distance;
    }

    /**
     * Gets max travel distance
     * @return distance that can be traveled with remaining fuel
     */
    public double getMaxTravelDistance() {
        return type.getMaxFuel();
    }

    /**
     * Use fuel
     * @param distance distance ship traveled
     */
    public void useFuel(double distance) {
        fuel -= (int) fuelRequiredToTravel(distance);
        Log.e("STATE", "Fuel used: " + distance + ". New fuel: " + fuel);
    }
}