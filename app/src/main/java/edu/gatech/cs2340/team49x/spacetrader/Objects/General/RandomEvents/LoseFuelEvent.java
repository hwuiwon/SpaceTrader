package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;

public class LoseFuelEvent extends RandomEvent {

    private final int distance;
    private double fuelLost;

    LoseFuelEvent(Random random) {
        distance = random.nextInt(1000);
    }

    @Override
    public String getTitle() {
        return "Oops!";
    }

    @Override
    public String getMessage() {
        return "Meteor shower created a hole!\n" +
                "You lost " + fuelLost + " extra fuel";
    }

    @Override
    public void doAction(PlayerInteractor playerInteractor,
                         CurrentSystemInteractor systemInteractor) {
        fuelLost = playerInteractor.getFuelRequired(distance);
        playerInteractor.decreaseFuel(distance);
    }
}
