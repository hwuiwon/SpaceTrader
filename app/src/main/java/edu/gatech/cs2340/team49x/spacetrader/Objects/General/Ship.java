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

    public void addToCargo(String good, int quantity) {
        cargo.add(good, quantity);
    }

    public void addToCargo(Inventory items) {
        cargo.add(items);
    }

    public void removeFromCargo(String good, int quantity) {
        cargo.add(good, -quantity);
    }

    public void removeFromCargo(Inventory items) {
        cargo.remove(items);
    }

    public int getAmountOf(String good) {
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
}