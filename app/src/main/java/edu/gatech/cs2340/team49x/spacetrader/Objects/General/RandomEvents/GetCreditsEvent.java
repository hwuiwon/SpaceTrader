package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;

/**
 * RandomEvent - get credit
 */
public class GetCreditsEvent extends RandomEvent {

    private static final int MAX_CREDITS_FOUND = 1000;
    private final int credits;

    GetCreditsEvent(Random random) {
        credits = random.nextInt(MAX_CREDITS_FOUND);
    }

    @Override
    public String getTitle() {
        return "Congratulations!";
    }

    @Override
    public String getMessage() {
        return "You have found an abandoned ship!\n" +
                "You have earned " + credits + " credits!";
    }

    @Override
    public void doAction(PlayerInteractor playerInteractor,
                         CurrentSystemInteractor systemInteractor) {
        playerInteractor.changeCredits(credits);
    }
}
