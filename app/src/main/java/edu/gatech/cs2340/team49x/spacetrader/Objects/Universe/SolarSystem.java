package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Market;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.RandomCondition;

public class SolarSystem implements Serializable {

    static final long serialVersionUID = 1L;
    private String name;
    private Coordinate coordinate;
    private TechLevel techLevel;
    private Resources resources;
    private Market market;

    public SolarSystem(String name, Coordinate coordinate,
                        TechLevel techLevel, Resources resources) {
        this.name = name;
        this.coordinate = coordinate;
        this.techLevel = techLevel;
        this.resources = resources;
        this.market = new Market(techLevel, resources);
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

    public Market getMarket() {
        return market;
    }

    public void setCondition(RandomCondition condition) {
        market.setCondition(condition);
    }

    public double distanceTo(SolarSystem other) {
        return coordinate.getDistance(other.coordinate);
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