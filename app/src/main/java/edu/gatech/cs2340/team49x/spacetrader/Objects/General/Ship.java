package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import android.util.Log;

import java.io.Serializable;
import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

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

    private final ShipType type;
    private final Inventory cargo;
    private int fuel;

    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Inventory();
        this.fuel = type.getMaxFuel();
    }

    public ShipType getType() {
        return type;
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