package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import android.arch.core.util.Function;
import android.util.Log;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class GetCreditsEvent extends RandomEvent {
    private static final int MAX_CREDITS_FOUND = 1000;
    private int credits;

    public GetCreditsEvent(Random random) {
        credits = random.nextInt(MAX_CREDITS_FOUND);
    }

    @Override
    public String getTitle() {
        return "Congradulations!";
    }

    @Override
    public String getMessage() {
        return "You have found an abandoned ship!\n" +
                "You have earned " + credits + " credits!";
    }

    @Override
    public void doAction(Player p, SolarSystem s) {
        p.changeCredits(credits);
    }
}
