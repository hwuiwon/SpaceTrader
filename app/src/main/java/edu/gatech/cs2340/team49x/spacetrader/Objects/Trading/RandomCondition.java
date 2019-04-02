package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Random;

public enum RandomCondition {

    DROUGHT,
    COLD,
    CROPFAIL,
    WAR,
    BOREDOM,
    PLAGUE,
    LACKOFWORKERS;

    public static RandomCondition getRandom(Random r) {
        return values()[(r.nextInt(values().length))];
    }
}