package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeGood;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class GetWaterEvent extends RandomEvent {
    public GetWaterEvent(Random random) {

    }

    @Override
    public String getTitle() {
        return "Congradulations!";
    }

    @Override
    public String getMessage() {
        return "Earth is near you!\n" +
                "You have obtained 1 WATER";
    }

    @Override
    public void doAction(Player p, SolarSystem s) {
        Inventory toAdd = new Inventory();
        toAdd.add(TradeGood.WATER, 1);
        p.addToCargo(toAdd);
    }
}
