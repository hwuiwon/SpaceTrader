package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;

public class SelectViewModel extends AndroidViewModel {

    private CurrentSystemInteractor interactor;

    public SelectViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelFacade.getInstance().getSystemInteractor();
    }

    /**
     * Gets resource
     * @return resource of current SolarSystem
     */
    public String getResourceDescription() {
        return interactor.getResources().getName();
    }

    /**
     * Gets tech level
     * @return tech level of current SolarSystem
     */
    public String getTechLevelDescription() {
        return interactor.getTechLevel().getName();
    }

    /**
     * Gets name of a system
     * @return name of current SolarSystem
     */
    public String getSystemName() {
        return interactor.getName();
    }
}
