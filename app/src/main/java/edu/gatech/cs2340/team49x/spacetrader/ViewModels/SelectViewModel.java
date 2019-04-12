package edu.gatech.cs2340.team49x.spacetrader.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;

/**
 * ViewModel used for SelectActivity
 */
public class SelectViewModel extends AndroidViewModel {

    private final CurrentSystemInteractor interactor;

    /**
     * Default constructor
     * @param application application
     */
    public SelectViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelFacade.getInstance().getSystemInteractor();
    }

    /**
     * Gets resource
     * @return resource of current SolarSystem
     */
    public String getResourceDescription() {
        return interactor.getResourceName();
    }

    /**
     * Gets tech level
     * @return tech level of current SolarSystem
     */
    public String getTechLevelDescription() {
        return interactor.getTechLevelName();
    }

    /**
     * Gets name of a system
     * @return name of current SolarSystem
     */
    public String getSystemName() {
        return interactor.getName();
    }
}
