package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Planet {

    private String name;
    private Coordinate coordinate;

    public Planet(String name, Coordinate coordinate) {
        this.name = name;
        this.coordinate = coordinate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public boolean equals(Planet o) {
        Planet planet = o;
        return planet.getName().equals(name) &&
                planet.getCoordinate().equals(coordinate);
    }
}