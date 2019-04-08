package edu.gatech.cs2340.team49x.spacetrader.Objects;

import java.util.Random;

/**
 * Tech level of a SolarSystem
 */
public enum TechLevel {

    PREAGRICULTURE("Pre-Agriculture"),
    AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"),
    RENAISSANCE("Renaissance"),
    EARLYINDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"),
    POSTINDUSTRIAL("Post-Industrial"),
    HITECH("Hi-Tech");

    private final double chance;
    private final String name;
    private static final double totalChance;

    static {
        double total = 0;
        for (TechLevel value : values()) {
            total += value.chance;
        }
        totalChance = total;
    }

    TechLevel(String name) {
        this.chance = (double) 1;
        this.name = name;
    }

    /**
     * Gets random tech level
     * @param random random object for randomizing
     * @return tech level
     */
    public static TechLevel getRandom(Random random) {
        double z = random.nextDouble() * totalChance;
        for (TechLevel value : values()) {
            z -= value.chance;
            if (z <= 0) {
                return value;
            }
        }
        return null;
    }

    /**
     * Gets name
     * @return name of tech level
     */
    public String getName() {
        return name;
    }
}