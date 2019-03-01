package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;

public class Ship {

    public enum ShipType {

        GNAT(5),
        FLEA(10),
        FIREFLY(15),
        MOSQUITO(20),
        BUMBLEBEE(25),
        BEETLE(30),
        HORNET(35),
        GRASSHOPPER(40),
        TERMITE(45),
        WASP(50);

        private int storage;

        ShipType(int storage) {
            this.storage = storage;
        }

        public int getStorage() {
            return storage;
        }
    }

    private ShipType type;
    private int storage;
    private Inventory cargo;

    public Ship(ShipType type) {
        this.type = type;
        cargo = new Inventory();
        storage = type.getStorage();
    }

    public ShipType getType() {
        return type;
    }

    public Inventory getCargo() {
        return cargo;
    }

    public boolean addToCargo(Inventory items) {
        if (cargo.getCount() + items.getCount() <= storage) {
            cargo.add(items);
            return true;
        }
        return false;
    }

    public boolean removeFromCargo(Inventory items) {
        if (cargo.has(items)) {
            cargo.remove(items);
            return true;
        }
        return false;
    }

    public boolean has(Inventory items) {
        return cargo.has(items);
    }

    public int cargoSpaceRemaining() {
        return storage - cargo.getCount();
    }
}