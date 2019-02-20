package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class SolarSystem {

    private Coord coordinates;
    private String name;
    private int techLevel;


    public SolarSystem(Coord coordinates, String name, int techLevel) {
        this.coordinates = coordinates;
        this.name = name;
        this.techLevel = techLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coord coordinates) {
        this.coordinates = coordinates;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
}
