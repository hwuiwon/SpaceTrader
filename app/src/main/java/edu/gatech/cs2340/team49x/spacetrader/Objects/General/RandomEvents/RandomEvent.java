package edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;

/**
 * Abstract class for all RandomEvents
 */
public abstract class RandomEvent {

    /**
     * @return title of random event
     */
    public abstract String getTitle();

    /**
     * @return message of random event
     */
    public abstract String getMessage();

    /**
     * @param playerInteractor playerInteractor
     * @param systemInteractor systemInteractor
     */
    public abstract void doAction(PlayerInteractor playerInteractor,
                                  CurrentSystemInteractor systemInteractor);
}