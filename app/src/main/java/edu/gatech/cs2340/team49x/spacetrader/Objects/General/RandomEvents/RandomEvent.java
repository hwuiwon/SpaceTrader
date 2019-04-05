package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import android.arch.core.util.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public abstract class RandomEvent {

    private static final double NULL_CHANCE = 0.6;
    private static final List<Function<Random,RandomEvent>> events = new ArrayList<>();

    static {
        events.add(GetCreditsEvent::new);
        events.add(LoseFuelEvent::new);
        events.add(GetWaterEvent::new);
        events.add(MarketConditionEvent::new);
    }

    public abstract String getTitle();

    public abstract String getMessage();

    public abstract void doAction(Player player, SolarSystem solarSystem);

    public static RandomEvent makeRandomEvent(Random random) {
        if (random.nextDouble() < NULL_CHANCE) {
            return null;
        }
        return events.get(random.nextInt(events.size())).apply(random);
    }
}