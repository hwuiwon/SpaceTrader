package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;

/**
 * Random event generator
 */
public class RandomEventGenerator {

    private static final double NULL_CHANCE = 0.7;
    private static final int NUM_EVENTS = 6;

    /**
     * Gets random event
     * @param random random object that returns number between 1~10
     * @param player current player
     * @return corresponding random event
     */
    public RandomEvent getRandomEvent(Random random, Player player) {
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
                case 4:
                    return new PirateEvent(random);
                case 5:
                    return new PoliceEvent(player);
            }
        }
        return null;
    }
}
