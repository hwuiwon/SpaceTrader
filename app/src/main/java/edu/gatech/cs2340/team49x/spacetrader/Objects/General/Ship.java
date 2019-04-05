package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import android.util.Log;

import java.io.Serializable;
import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

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

    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Inventory();
        this.fuel = type.getMaxFuel();
    }

    public Set<Tradable> getCargoSet() {
        return cargo.getItemSet();
    }

    public int getFuel() {
        return fuel;
    }

    public void addToCargo(Inventory items) {
        cargo.add(items);
    }

    public void removeFromCargo(Inventory items) {
        cargo.remove(items);
    }

    public int getAmountOf(Tradable good) {
        return cargo.getQuantity(good);
    }

    public int cargoSpaceRemaining() {
        return type.getStorage() - cargo.getCount();
    }

    public String getName() {
        return type.name();
    }

    public int getSpeed() {
        return type.getSpeed();
    }

    public double fuelRequiredToTravel(double distance) {
        return distance;
    }

    public double getMaxTravelDistance() {
        return type.getMaxFuel();
    }

    public void useFuel(double distance) {
        fuel -= (int) fuelRequiredToTravel(distance);
        Log.e("STATE", "Fuel used: " + distance + ". New fuel: " + fuel);
    }
}