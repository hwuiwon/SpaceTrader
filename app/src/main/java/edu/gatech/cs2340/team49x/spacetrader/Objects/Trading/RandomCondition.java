package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Random;

/**
 * RandomCondition object
 */
public enum RandomCondition {

    DROUGHT,
    COLD,
    CROPFAIL,
    WAR,
    BOREDOM,
    PLAGUE,
    LACKOFWORKERS;

    /**
     * Gets random condition
     * @param random random object for randomizing
     * @return random condition
     */
    public static RandomCondition getRandom(Random random) {
        return values()[(random.nextInt(values().length))];
    }
}