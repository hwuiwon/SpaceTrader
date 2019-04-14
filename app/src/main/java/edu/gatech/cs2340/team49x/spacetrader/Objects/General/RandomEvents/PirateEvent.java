package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;


/**
 * RandomEvent - pirate encounter
 */
public class PirateEvent extends RandomEvent {

    private static final int MAX_LOOT = 500;
    private final int credits;

    PirateEvent(Random random) {
        credits = random.nextInt(MAX_LOOT);
    }

    @Override
    public String getTitle() {
        return "Pirate attack!";
    }

    @Override
    public String getMessage() {
        return "You have encountered space pirates\n" +
                "You paid " + credits + " credits..";
    }

    @Override
    public void doAction(PlayerInteractor playerInteractor,
                         CurrentSystemInteractor systemInteractor) {
        playerInteractor.changeCredits(credits);
    }
}