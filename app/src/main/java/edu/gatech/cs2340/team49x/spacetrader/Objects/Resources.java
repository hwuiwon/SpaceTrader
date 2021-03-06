package edu.gatech.cs2340.team49x.spacetrader.Objects;

import java.util.Random;

/**
 * Resource object
 */
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
    private static final double totalChance;

    static {
        double total = 0;
        for (Resources value : values()) {
            total += value.chance;
        }
        totalChance = total;
    }

    Resources(double chance, String name) {
        this.chance = chance;
        this.name = name;
    }

    /**
     * Gets resource
     * @param random random object for randomizing
     * @return resource
     */
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

    /**
     * Gets name
     * @return name of a resource
     */
    public String getName() {
        return name;
    }
}