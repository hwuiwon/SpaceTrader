package edu.gatech.cs2340.team49x.spacetrader.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Ship;

/**
 * ViewModel used for ShipActivity
 */
public class ShipViewModel extends AndroidViewModel {

    private PlayerInteractor playerInteractor;

    /**
     * Default constructor
     * @param application application
     */
    public ShipViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Gets ship
     * @return current ship
     */
    public Ship.ShipType getShipType() {
        return ModelFacade.getInstance().getShipType();
    }

    /**
     * Sets ship
     * @param shipType new ship
     */
    public void setShipType(Ship.ShipType shipType) {
        ModelFacade.getInstance().setShipType(shipType);
    }

    /**
     * Sets fuel to max
     */
    public void maxFuel() {
        ModelFacade.getInstance().maxFuel();
    }

    /**
     * List of ship types
     * @return all ship types
     */
    public List<Ship.ShipType> getShipList() {
        Ship.ShipType[] types = Ship.ShipType.values();
        List<Ship.ShipType> shipTypes = Arrays.asList(types);
        return shipTypes;
    }

    /**
     * Gets credit
     * @return player's credit
     */
    public int getCredits() {
        playerInteractor = ModelFacade.getInstance().getPlayerInteractor();
        return playerInteractor.getCredits();
    }
}