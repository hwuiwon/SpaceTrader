package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Ship {

    public enum ShipType {
        GNAT(5), FLEA(10), FIREFLY(15),
        MOSQUITO(20), BUMBLEBEE(25), BEETLE(30),
        HORNET(35), GRASSHOPPER(40), TERMITE(45), WASP(50);

        private int storage;

        ShipType(int storage) {
            this.storage = storage;
        }

        public int getStorage() {
            return storage;
        }
    }

    private ShipType type;
    private String[] storage;

    public Ship(ShipType type) {
        this.type = type;
        storage = new String[type.getStorage()];
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