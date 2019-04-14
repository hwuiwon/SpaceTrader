package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import java.util.Set;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeGood;

/**
 * RandomEvent - police encounter
 */
public class PoliceEvent extends RandomEvent {

    private final Set<Tradable> inventory;

    PoliceEvent(Player player) {
        inventory = player.getShipCargo();
    }

    @Override
    public String getTitle() {
        return "Beep Beep";
    }

    @Override
    public String getMessage() {
        if (inventory.contains(TradeGood.NARCOTICS)) {
            return "You are fined by police.\n" +
                    "Carrying narcotics is illegal";
        }
        return "You didn't have any illegal items\nPolice let you go";
    }

    @Override
    public void doAction(PlayerInteractor playerInteractor,
                         CurrentSystemInteractor systemInteractor) {
        if (inventory.contains(TradeGood.NARCOTICS)) {
            playerInteractor.changeCredits(-(playerInteractor.getCredits() / 2));
        }
    }
}