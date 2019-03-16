package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class TravelViewModel extends AndroidViewModel {
    private CurrentSystemInteractor systemInteractor;
    private PlayerInteractor playerInteractor;
    private List<SolarSystem> systemsList;
    public TravelViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        systemInteractor = ModelFacade.getInstance().getSystemInteractor();
        playerInteractor = ModelFacade.getInstance().getPlayerInteractor();
        systemsList = systemInteractor.getSystemsWithinRange(playerInteractor.getMaxTravelDistance());
    }

    public List<SolarSystem> getNearbySystems() {
        return systemsList;
    }

    public String getName() {
        return systemInteractor.getName();
    }

    public int getFuel() {
        return playerInteractor.getFuel();
    }

    public double getDistanceTo(int pos) {
        return systemInteractor.distanceTo(systemsList.get(pos));
    }

    public double getTimeToTravel(int pos) {
        return getDistanceTo(pos) / playerInteractor.getSpeed();
    }

    /**
     * Travels to the SolarSystem at position pos.
     *
     * @param pos the index of the destination system.
     */
    public void goTo(int pos) {
        playerInteractor.decreaseFuel(getDistanceTo(pos));
        systemInteractor.setCurrentSystem(systemsList.get(pos));
        Log.d("STATE", "Moved to " + systemsList.get(pos).getName());
    }
}
