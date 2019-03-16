package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.util.Random;

public enum TechLevel {

    PREAGRICULTURE(1, "Pre-Agriculture"),
    AGRICULTURE(1, "Agriculture"),
    MEDIEVAL(1, "Medieval"),
    RENAISSANCE(1, "Renaissance"),
    EARLYINDUSTRIAL(1, "Early Industrial"),
    INDUSTRIAL(1, "Industrial"),
    POSTINDUSTRIAL(1, "Post-Industrial"),
    HITECH(1, "Hi-Tech");

    private double chance;
    private String name;
    private static double totalChance;

    static {
        for (TechLevel value : values()) {
            totalChance += value.chance;
        }
    }

    TechLevel(double chance, String name) {
        this.chance = chance;
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