package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeGood;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class GetWaterEvent extends RandomEvent {

    final private int num;

    GetWaterEvent(Random random) {
        num = random.nextInt(2) + 1;
    }

    @Override
    public String getTitle() {
        return "Congratulations!";
    }

    @Override
    public String getMessage() {
        return "Earth is near you!\n" +
                "You have obtained" + num + "WATER";
    }

    @Override
    public void doAction(Player player, SolarSystem solarSystem) {
        Inventory toAdd = new Inventory();
        toAdd.add(TradeGood.WATER,
                num > player.cargoSpaceRemaining() ? player.cargoSpaceRemaining() : num);
        player.addToCargo(toAdd);
    }
}
