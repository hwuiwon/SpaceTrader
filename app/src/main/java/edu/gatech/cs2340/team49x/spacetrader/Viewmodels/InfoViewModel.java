package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.InvenItem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class InfoViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;
    public InfoViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        interactor = ModelFacade.getInstance().getPlayerInteractor();
    }

    public String getName() {
        return interactor.getName();
    }

    public Player getPlayer() {
        return interactor.getPlayer();
    }

    public List<InvenItem> getInvenItems() {
        List<InvenItem> itemList = new ArrayList<>();
        for (Tradable good : interactor.getInventorySet()) {
            itemList.add(new InvenItem(good.getName(), interactor.amountOf(good)));
        }
        return itemList;
    }
}
