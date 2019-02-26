package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.util.Random;

public enum TechLevel {

    PREAGRICULTURE(1),
    AGRICULTURE(1),
    MEDIEVAL(1),
    RENAISSANCE(1),
    EARLYINDUSTRIAL(1),
    INDUSTRIAL(1),
    POSTINDUSTRIAL(1),
    HITECH(1);

    private double chance;
    private static double totalChance;

    static {
        for (TechLevel value : values()) {
            totalChance += value.chance;
        }
    }

    TechLevel(double chance) {
        this.chance = chance;
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
}