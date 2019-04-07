package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.RandomCondition;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

/**
 * This class is used by SelectViewModel and TravelViewModel
 * to connect with the backend.
 */
public class CurrentSystemInteractor {

    private SolarSystem currentSystem;
    private Universe universe;
    private Game game;

    /**
     * Initialize interactor
     * @param game current game
     */
    public void init(Game game) {
        this.game = game;
        this.currentSystem = game.getCurrentSystem();
        this.universe = game.getUniverse();
    }

    /**
     * Gets resource name
     * @return resource of current system
     */
    public String getResourceName() {
        return currentSystem.resourceName();
    }

    /**
     * Gets tech level name
     * @return tech level of current system
     */
    public String getTechLevelName() {
        return currentSystem.techLevelName();
    }

    /**
     * Gets name
     * @return name of current system
     */
    public String getName() {
        return currentSystem.getName();
    }

    /**
     * Sets current system
     * @param newSystem system that will replace current system
     */
    public void setCurrentSystem(SolarSystem newSystem) {
        game.setCurrentSystem(newSystem);
        init(game);
    }

    /**
     * Sets condition
     * @param condition condition that will replace current condition
     */
    public void setCondition(RandomCondition condition) {
        currentSystem.setCondition(condition);
    }

    /**
     * Gets system within range
     * @param range distance
     * @return list of solar systems within range
     */
    public List<SolarSystem> getSystemsWithinRange(double range) {
        return universe.getSystemsInRange(currentSystem, range);
    }

    /**
     * Gets distance to other solar system
     * @param other other solar system
     * @return distance
     */
    public double distanceTo(SolarSystem other) {
        return currentSystem.distanceTo(other);
    }
}