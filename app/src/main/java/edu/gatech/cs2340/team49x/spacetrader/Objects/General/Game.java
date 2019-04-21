package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import java.io.Serializable;
import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

/**
 * Main Game class
 */
public class Game implements Serializable {

    static final long serialVersionUID = 1L;
    private Player player;
    private Difficulty difficulty;
    private Universe universe;
    private SolarSystem currentSystem;
    private Random random = new Random();

    /**
     * Default Constructor
     */
    public Game() {
        random = new Random();
    }

    /**
     * Default Constructor
     * @param player current player
     * @param difficulty current game difficulty
     * @param numSystems number of systems
     */
    public Game(Player player, Difficulty difficulty, int numSystems) {
        this.player = player;
        this.difficulty = difficulty;
        universe = new Universe(random, numSystems);
        currentSystem = universe.getSolarSystem(random.nextInt(numSystems));
    }

    /**
     * Gets player
     * @return current player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets difficulty
     * @return current difficulty
     */
    public Difficulty getDifficulty() {
        return difficulty;
    }

    /**
     * Gets ship
     * @return player's ship
     */
    public Ship.ShipType getShipType() {
        return player.getShipType();
    }

    /**
     * Sets ship
     * @param shipType new ship
     */
    public void setShipType(Ship.ShipType shipType) {
        player.setShipType(shipType);
    }

    /**
     * Sets fuel to max
     */
    public void maxFuel() {
        player.maxFuel();
    }

    /**
     * Prints player
     * @return current player name
     */
    public String printPlayer() {
        return player.toString();
    }

    /**
     * Gets game universe
     * @return current universe
     */
    public Universe getUniverse() {
        return universe;
    }

    /**
     * Gets current system
     * @return current solar system
     */
    public SolarSystem getCurrentSystem() {
        return currentSystem;
    }

    /**
     * Sets current system
     * @param currentSystem solar system that will replace current solar system
     */
    public void setCurrentSystem(SolarSystem currentSystem) {
        this.currentSystem = currentSystem;
    }
}