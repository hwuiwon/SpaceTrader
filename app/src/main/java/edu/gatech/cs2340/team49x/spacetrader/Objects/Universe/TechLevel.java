package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.util.Random;

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
    private static double totalChance = 0;

    static {
        for (TechLevel value : values()) {
            totalChance += value.chance;
        }
    }

    TechLevel(String name) {
        this.chance = (double) 1;
        this.name = name;
    }

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

    public String getName() {
        return name;
    }
}