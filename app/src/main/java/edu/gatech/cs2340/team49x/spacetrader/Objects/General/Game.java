package edu.gatech.cs2340.team49x.spacetrader.Objects.General;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

public class Game {

    private Player player;
    private Difficulty difficulty;
    private Universe universe;
    private Random random;

    public Game() {
        random = new Random();
    }

    public Player getPlayerInfo() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void createUniverse(int numSystems) {
        universe = new Universe(random, numSystems);
    }

    public String printPlayer() {
        return player.toString();
    }

    public String printUniverse() {
        return universe.toString();
    }
}