package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.Currency;

import edu.gatech.cs2340.team49x.spacetrader.Model.CurrentSystemInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;

public class SelectViewModel extends AndroidViewModel {
    private CurrentSystemInteractor interactor;
    public SelectViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelFacade.getInstance().getSystemInteractor();
    }

    public String getResourceDiscription() {
        return "Resources: " + interactor.getResources();
    }

    public String getTechLevelDiscription() {
        return "Tech Level: " + interactor.getTechLevel();
    }

    public String getSystemName() {
        return interactor.getName();
    }
}
