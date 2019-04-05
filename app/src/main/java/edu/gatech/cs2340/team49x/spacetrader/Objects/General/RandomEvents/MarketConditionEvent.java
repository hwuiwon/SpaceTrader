package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.RandomCondition;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class MarketConditionEvent extends RandomEvent{

    private final RandomCondition condition;

    MarketConditionEvent(Random random) {
        condition = RandomCondition.getRandom(random);
    }

    @Override
    public String getTitle() {
        return "Alert!";
    }

    @Override
    public String getMessage() {
        return "This system is afflicted by the\n" +
                "following condition: " + condition + ".\n" +
                "Market prices may have changed!";
    }

    @Override
    public void doAction(Player player, SolarSystem solarSystem) {
        solarSystem.setCondition(condition);
    }
}
