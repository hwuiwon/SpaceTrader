package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class Ship {

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

        private int storage;
        private int speed;
        private int maxFuel;

        ShipType(int storage, int speed, int maxFuel) {
            this.storage = storage;
            this.speed = speed;
            this.maxFuel = maxFuel;
        }

        public int getStorage() {
            return storage;
        }

        public int getSpeed() {
            return speed;
        }

        public int getMaxFuel() {
            return maxFuel;
        }
    }

    private ShipType type;
    private Inventory cargo;
    private int fuel;

    public Ship(ShipType type) {
        this.type = type;
        this.cargo = new Inventory();
        this.fuel = type.getMaxFuel();
    }

    public ShipType getType() {
        return type;
    }

    public Inventory getCargo() {
        return cargo;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel += fuel;
    }

    public void addToCargo(Tradable good, int quantity) {
        cargo.add(good, quantity);
    }

    public void addToCargo(Inventory items) {
        cargo.add(items);
    }

    public void removeFromCargo(Tradable good, int quantity) {
        cargo.add(good, -quantity);
    }

    public void removeFromCargo(Inventory items) {
        cargo.remove(items);
    }

    public int getAmountOf(Tradable good) {
        return cargo.getQuantity(good);
    }

    public boolean has(Inventory items) {
        return cargo.has(items);
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
}