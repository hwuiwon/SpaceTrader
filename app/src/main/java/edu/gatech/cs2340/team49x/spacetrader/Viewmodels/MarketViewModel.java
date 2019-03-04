package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.TradeInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;

public class MarketViewModel extends AndroidViewModel {
    public MarketViewModel(@NonNull Application application) {
        super(application);
    }

    private Item[] items;
    private TradeInteractor interactor;

    public void init() {
        interactor = ModelFacade.getInstance().startTrade();
        //initialize item array by getting data from the interactor
    }

    public Item[] getItems() {
        return items;
    }
}
