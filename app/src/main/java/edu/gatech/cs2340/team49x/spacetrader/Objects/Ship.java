package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Ship {
    private ShipType type;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getType() {
        return type;
    }

    public void setType(ShipType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "type=" + type +
                '}';
    }
}
