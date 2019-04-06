package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeGood;

public class GetWaterEvent extends RandomEvent {

    private final int num;

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
    public void doAction(PlayerInteractor playerInteractor,
                         CurrentSystemInteractor systemInteractor) {
        Inventory toAdd = new Inventory();
        int space = playerInteractor.getCargoRemaining();
        toAdd.add(TradeGood.WATER,
                (num > space) ? space : num);
        playerInteractor.addToCargo(toAdd);
    }
}
