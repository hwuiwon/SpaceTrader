package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;

public class PlayerInteractor {
    private Player player;
    private Ship ship;

    public void init(Player player) {
        this.player = player;
        this.ship = player.getShip();
    }

    public int getFuel() {
        return ship.getFuel();
    }

    public int getSpeed() {
        return ship.getSpeed();
    }

    public double getMaxTravelDistance() {
        return ship.getMaxTravelDistance();
    }


    public double fuelRequiredToTravel(double distance) {
        return ship.fuelRequiredToTravel(distance);
    }

    public void decreaseFuel(double distance) {
        ship.useFuel(distance);
    }
}
