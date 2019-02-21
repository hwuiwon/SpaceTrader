package edu.gatech.cs2340.team49x.spacetrader.Objects;
import java.util.ArrayList;

public class Universe {

    private ArrayList<SolarSystem> solarSystems;

    public Universe() {
        this(new ArrayList<SolarSystem>());
    }

    public Universe(ArrayList<SolarSystem> solarSystems) {
        this.solarSystems = solarSystems;
    }

    public void addSolarSystem(SolarSystem system) {
        solarSystems.add(system);
    }

    public ArrayList<SolarSystem> getSolarSystems() {
        return solarSystems;
    }
}