package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

public class Planet {

    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Planet o) {
        Planet planet = o;
        return planet.getName().equals(name);
    }
}