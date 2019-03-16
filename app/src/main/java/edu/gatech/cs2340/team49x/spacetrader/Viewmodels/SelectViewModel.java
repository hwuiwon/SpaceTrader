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

    public String getResourceDiscription() {
        return interactor.getResources().name();
    }

    public String getTechLevelDiscription() {
        return interactor.getTechLevel().name();
    }

    public String getSystemName() {
        return interactor.getName();
    }
}
