package edu.gatech.cs2340.team49x.spacetrader.Objects;

import java.util.Random;

public enum Resources {

    NOSPECIALRESOURCES(9, "No Special Resources"),
    MINERALRICH(1, "Mineral Rich"),
    MINERALPOOR(1, "Mineral Poor"),
    DESERT(1, "Desert"),
    LOTSOFWATER(1, "Lots of Water"),
    RICHSOIL(1, "Rich Soil"),
    POORSOIL(1, "Poor Soil"),
    RICHFAUNA(1, "Rich Fauna"),
    LIFELESS(1, "Lifeless"),
    WEIRDMUSHROOMS(1, "Weird Mushrooms"),
    LOTSOFHERBS(1, "Lots of Herbs"),
    ARTISTIC(1, "Artistic"),
    WARLIKE(1, "War-Like");

    private final double chance;
    private final String name;
    private static double totalChance;

    static {
        for (Resources value : values()) {
            totalChance += value.chance;
        }
    }

    Resources(double chance, String name) {
        this.chance = chance;
        this.name = name;
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

    public String getName() {
        return name;
    }
}