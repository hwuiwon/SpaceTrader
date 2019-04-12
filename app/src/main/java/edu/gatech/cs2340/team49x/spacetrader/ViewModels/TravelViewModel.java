package edu.gatech.cs2340.team49x.spacetrader.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents.RandomEvent;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.RandomEvents.RandomEventGenerator;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

/**
 * ViewModel used for TravelActivity
 */
public class TravelViewModel extends AndroidViewModel {

    private CurrentSystemInteractor systemInteractor;
    private PlayerInteractor playerInteractor;
    private List<SolarSystem> systemsList;
    private RandomEvent event;

    /**
     * Default constructor
     * @param application application
     */
    public TravelViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Initializes interactors
     */
    public void init() {
        systemInteractor = ModelFacade.getInstance().getSystemInteractor();
        playerInteractor = ModelFacade.getInstance().getPlayerInteractor();
        systemsList =
                systemInteractor.getSystemsWithinRange(playerInteractor.getMaxTravelDistance());
    }

    /**
     * Gets nearby SolarSystems
     * @return list of SolarSystems
     */
    public List<SolarSystem> getNearbySystems() {
        return Collections.unmodifiableList(systemsList);
    }

    /**
     * Gets name
     * @return name of current SolarSystem
     */
    public String getName() {
        return systemInteractor.getName();
    }

    /**
     * Gets remaining fuel
     * @return remaining fuel of a ship
     */
    public int getFuel() {
        return playerInteractor.getFuel();
    }

    /**
     * Gets distance between two position
     * @param pos position
     * @return distance
     */
    public double getDistanceTo(int pos) {
        return systemInteractor.distanceTo(systemsList.get(pos));
    }

    /**
     * Gets time that takes to travel to other position
     * @param pos position
     * @return time
     */
    public double getTimeToTravel(int pos) {
        return getDistanceTo(pos) / playerInteractor.getSpeed();
    }

    /**
     * Gets title of an event
     * @return event title
     */
    public String getEventTitle() {
        return (event == null) ? null : event.getTitle();
    }

    /**
     * Gets message of an event
     * @return event message
     */
    public String getEventMessage() {
        return (event == null) ? null : event.getMessage();
    }

    /**
     * Travels to the SolarSystem at position pos.
     * @param pos the index of the destination system.
     */
    public void goTo(int pos) {
        SolarSystem system = systemsList.get(pos);
        playerInteractor.decreaseFuel(getDistanceTo(pos));
        systemInteractor.setCurrentSystem(system);
        system.setCondition(null);
        event = new RandomEventGenerator().getRandomEvent(new Random()); // change this random later
        if (event != null) {
            event.doAction(playerInteractor, systemInteractor);
        }

        try {
            ModelFacade.getInstance().saveGame(getApplication().getApplicationContext());
            Log.d("GAME", "Game saved.");
        } catch (IOException e) {
            Log.e("GAME", "Failed to save game.", e);
        }
    }
}
