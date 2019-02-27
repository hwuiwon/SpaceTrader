package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeGood;

public class SolarSystem {

    private String name;
    private Coordinate coordinate;
    private TechLevel techLevel;
    private List<Planet> planets;
    private Resources resources;
    private Random random;
    private Map<TradeGood, Integer> prices;


    public SolarSystem(String name, Coordinate coordinate,
                       TechLevel techLevel, Resources resources, Random random, List<Planet> planets) {
        this.name = name;
        this.coordinate = coordinate;
        this.techLevel = techLevel;
        this.resources = resources;
        this.random = random;
        this.planets = planets;
    }

    public SolarSystem(String name, Coordinate coordinate,
                       TechLevel techLevel, Resources resources, Random random) {
        this(name, coordinate, techLevel, resources, random, new ArrayList<Planet>());
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

    private void initializePrices() {
        prices = new HashMap<>();
        for (TradeGood good : TradeGood.values()) {
            if (good.canBeProducedBy(techLevel) || good.canBeUsedBy(techLevel)) {
                int price = good.getBasePrice();
                //Do price initialization stuff
                prices.put(good, price);
            }
        }
    }
}
