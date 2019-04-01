package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class LoseFuelEvent extends RandomEvent {

    private int distance;
    private Ship ship;

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
                "You lost " + ship.fuelRequiredToTravel(distance) + " extra fuel";
    }

    @Override
    public void doAction(Player player, SolarSystem solarSystem) {
        ship = player.getShip();
        ship.useFuel(distance);
    }
}
