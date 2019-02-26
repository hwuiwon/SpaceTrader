package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    private String name;
    private Coordinate coordinate;
    private TechLevel techLevel;
    private List<Planet> planets;
    private Resources resources;


    public SolarSystem(String name, Coordinate coordinate,
                       TechLevel techLevel, Resources resources, List<Planet> planets) {
        this.name = name;
        this.coordinate = coordinate;
        this.techLevel = techLevel;
        this.resources = resources;
        this.planets = planets;
    }

    public SolarSystem(String name, Coordinate coordinate,
                       TechLevel techLevel, Resources resources) {
        this(name, coordinate, techLevel, resources, new ArrayList<Planet>());
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

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "\nSolarSystem {" +
                "name = '" + name + '\'' +
                ", coordinate = " + coordinate +
                ", techLevel = " + techLevel +
                ", resources = " + resources +
                "}";
    }
}
