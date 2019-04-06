package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.RandomCondition;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

public class CurrentSystemInteractor {

    private SolarSystem currentSystem;
    private Universe universe;
    private Game game;

    public void init(Game game) {
        this.game = game;
        this.currentSystem = game.getCurrentSystem();
        this.universe = game.getUniverse();
    }

    public String getResourceName() {
        return currentSystem.resourceName();
    }

    public String getTechLevelName() {
        return currentSystem.techLevelName();
    }

    public String getName() {
        return currentSystem.getName();
    }

    public void setCurrentSystem(SolarSystem newSystem) {
        game.setCurrentSystem(newSystem);
        init(game);
    }

    public void setCondition(RandomCondition condition) {
        currentSystem.setCondition(condition);
    }

    public List<SolarSystem> getSystemsWithinRange(double range) {
        return universe.getSystemsInRange(currentSystem, range);
    }

    public double distanceTo(SolarSystem other) {
        return currentSystem.distanceTo(other);
    }

}