package edu.gatech.cs2340.team49x.spacetrader.Objects.Universe;

import java.util.Random;

public enum Resources {

    NOSPECIALRESOURCES(9),
    MINERALRICH(1),
    MINERALPOOR(1),
    DESERT(1),
    TSOFWATER(1),
    RICHSOIL(1),
    POORSOIL(1),
    RICHFAUNA(1),
    LIFELESS(1),
    WEIRDMUSHROOMS(1),
    LOTSOFHERBS(1),
    LOTSOFWATER(1),
    ARTISTIC(1),
    WARLIKE(1);

    private double chance;
    private static double totalChance;

    static {
        for (Resources value : values()) {
            totalChance += value.chance;
        }
    }

    Resources(double chance) {
        this.chance = chance;
    }

    public static Resources getRandom(Random random) {
        double z = random.nextDouble() * totalChance;
        for (Resources value : values()) {
            z -= value.chance;
            if (z <= 0) {
                return value;
            }
        }
        return null;
    }
}