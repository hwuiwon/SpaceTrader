package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.TechLevel;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

public class CurrentSystemInteractor {

    SolarSystem currentSystem;
    Universe universe;
    Game game;

    public void init(Game game) {
        this.game = game;
        this.currentSystem = game.getCurrentSystem();
        this.universe = game.getUniverse();
    }
    public Resources getResources() {
        return currentSystem.getResources();
    }

    public TechLevel getTechLevel() {
        return currentSystem.getTechLevel();
    }

    public String getName() {
        return currentSystem.getName();
    }

    public void setCurrentSystem(SolarSystem newSystem) {
        game.setCurrentSystem(newSystem);
        init(game);
    }

    public List<SolarSystem> getSystemsWithinRange(double range) {
        return universe.getSystemsInRange(currentSystem, range);
    }

    public double distanceTo(SolarSystem other) {
        return currentSystem.distanceTo(other);
    }
}