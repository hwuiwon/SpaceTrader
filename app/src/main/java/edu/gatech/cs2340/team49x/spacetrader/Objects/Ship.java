package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Ship {

    public enum ShipType {
        GNAT, FLEA, FIREFLY,
        MOSQUITO, BUMBLEBEE, BEETLE,
        HORNET, GRASSHOPPER, TERMITE, WASP
    }

    private ShipType type;
    private String[] storage;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    public String[] getStorage() {
        return storage;
    }

    public void setStorage(String[] storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "type=" + type +
                '}';
    }
}