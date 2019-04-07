package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import android.support.annotation.NonNull;

import java.io.Serializable;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.TechLevel;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Market;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.RandomCondition;

/**
 * SolarSystem object
 */
public class SolarSystem implements Serializable {

    static final long serialVersionUID = 1L;
    private final String name;
    private final Coordinate coordinate;
    private final TechLevel techLevel;
    private final Resources resources;
    private final Market market;

    /**
     * Default constructor
     * @param name name of solar system
     * @param coordinate location of solar system
     * @param techLevel tech level of solar system
     * @param resources resource in solar system
     */
    public SolarSystem(String name, Coordinate coordinate,
                        TechLevel techLevel, Resources resources) {
        this.name = name;
        this.coordinate = coordinate;
        this.techLevel = techLevel;
        this.resources = resources;
        this.market = new Market(techLevel, resources);
    }

    /**
     * Gets name
     * @return name of solar system
     */
    public String getName() {
        return name;
    }

    /**
     * Gets tech level
     * @return name of tech level
     */
    public String techLevelName() {
        return techLevel.getName();
    }

    /**
     * Gets resource
     * @return name of resource
     */
    public String resourceName() {
        return resources.getName();
    }

    /**
     * Gets market
     * @return market of current solar system
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Sets condition
     * @param condition new condition of current solar system
     */
    public void setCondition(RandomCondition condition) {
        market.setCondition(condition);
    }

    /**
     * Gets distance between other solar system
     * @param other other solar system
     * @return distance
     */
    public double distanceTo(SolarSystem other) {
        return coordinate.getDistance(other.coordinate);
    }

    @NonNull
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