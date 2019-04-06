package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;

public abstract class RandomEvent {

    public abstract String getTitle();

    public abstract String getMessage();

    public abstract void doAction(PlayerInteractor playerInteractor,
                                  CurrentSystemInteractor systemInteractor);

}