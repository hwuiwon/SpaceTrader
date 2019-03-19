package edu.gatech.cs2340.team49x.spacetrader.Model;

import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class PlayerInteractor {
    private Player player;
    private Ship ship;

    public void init(Player player) {
        this.player = player;
        this.ship = player.getShip();
    }

    public String getName() {
        return player.getName();
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

    public Player getPlayer() {
        return player;
    }

    public double fuelRequiredToTravel(double distance) {
        return ship.fuelRequiredToTravel(distance);
    }

    public void decreaseFuel(double distance) {
        ship.useFuel(distance);
    }

    public Set<Tradable> getInventorySet() {
        return ship.getCargoSet();
    }

    public int amountOf(Tradable good) {
        return ship.getAmountOf(good);
    }
}
