package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

public class Coordinate {

    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Coordinate coordinate) {
        return Math.round(Math.sqrt((this.x - coordinate.x) * (this.x - coordinate.x)
                + (this.y - coordinate.y) * (this.y - coordinate.y)) * 100000.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return (x << 15) | y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}