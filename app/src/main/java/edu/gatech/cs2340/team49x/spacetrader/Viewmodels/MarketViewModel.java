package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;

public class MarketViewModel extends AndroidViewModel {
    public MarketViewModel(@NonNull Application application) {
        super(application);
    }

    private Item[] items;

    public Item[] getItems() {
        return items;
    }
}
