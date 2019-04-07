package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

public class RandomEventGenerator {
    private static final double NULL_CHANCE = 0.6;
    private static final int NUM_EVENTS = 4;
    public RandomEvent getRandomEvent(Random random) {
        if (random.nextDouble() >= NULL_CHANCE) {
            switch (random.nextInt(NUM_EVENTS)) {
                case 0:
                    return new GetCreditsEvent(random);
                case 1:
                    return new GetWaterEvent(random);
                case 2:
                    return new LoseFuelEvent(random);
                case 3:
                    return new MarketConditionEvent(random);
            }
        }
        return null;
    }
}