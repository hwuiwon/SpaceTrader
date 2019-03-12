package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class Ship {

    public enum ShipType {

        GNAT(5, 20000),
        FLEA(10, 22500),
        FIREFLY(15, 25000),
        MOSQUITO(20, 27500),
        BUMBLEBEE(25, 30000),
        BEETLE(30, 32500),
        HORNET(35, 35000),
        GRASSHOPPER(40, 37500),
        TERMITE(45, 40000),
        WASP(50, 42500);

        private int storage;
        private int speed;

        ShipType(int storage, int speed) {
            this.storage = storage;
            this.speed = speed;
        }

        public int getStorage() {
            return storage;
        }

        public int getSpeed() {
            return speed;
        }
    }

    private ShipType type;
    private Inventory cargo;

    public Ship(ShipType type) {
        this.type = type;
        cargo = new Inventory();
    }

    public ShipType getType() {
        return type;
    }

    public Inventory getCargo() {
        return cargo;
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