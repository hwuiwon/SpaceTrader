package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.io.Serializable;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Market;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.RandomCondition;

public class SolarSystem implements Serializable {

    static final long serialVersionUID = 1L;
    private final String name;
    private final Coordinate coordinate;
    private final TechLevel techLevel;
    private final Resources resources;
    private final Market market;

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

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public Resources getResources() {
        return resources;
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