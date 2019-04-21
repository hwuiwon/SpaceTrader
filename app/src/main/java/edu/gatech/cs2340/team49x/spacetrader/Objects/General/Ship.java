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

        GNAT(5, 20000, 500000),
        FLEA(10, 22500, 1000000),
        FIREFLY(15, 25000, 1500000),
        MOSQUITO(20, 27500, 2000000),
        BUMBLEBEE(25, 30000, 2500000),
        BEETLE(30, 32500, 3000000),
        HORNET(35, 35000, 3500000),
        GRASSHOPPER(40, 37500, 4000000),
        TERMITE(45, 40000, 4500000),
        WASP(50, 42500, 5000000);

        private final int storage;
        private final int speed;
        private final int maxFuel;

        ShipType(int storage, int speed, int maxFuel) {
            this.storage = storage;
            this.speed = speed;
            this.maxFuel = maxFuel;
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

    private ShipType type;
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

    /**
     * Charges fuel to max
     */
    public void maxFuel() {
        fuel = type.getMaxFuel();
    }

    /**
     * Gets ship type
     * @return ship type
     */
    public ShipType getShipType() {
        return type;
    }

    /**
     * Sets ship type
     * @param shipType new ship type
     */
    public void setShipType(ShipType shipType) {
        type = shipType;
    }
}