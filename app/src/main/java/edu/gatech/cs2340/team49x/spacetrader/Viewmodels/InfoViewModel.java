package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.InvenItem;

public class InfoViewModel extends AndroidViewModel {

    private PlayerInteractor interactor;

    public InfoViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Initializes InfoViewModel
     */
    public void init() {
        interactor = ModelFacade.getInstance().getPlayerInteractor();
    }

    /**
     * Gets player name
     * @return name of a player
     */
    public String getName() {
        return interactor.getName();
    }

// --Commented out by Inspection START (4/6/2019 5:34 AM):
//    /**
//     * Gets player
//     * @return current player
//     */
//    public Player getPlayer() {
//        return interactor.getPlayer();
//    }
// --Commented out by Inspection STOP (4/6/2019 5:34 AM)

    /**
     * Gets player credit
     * @return credit of a player
     */
    public int getCredit() {
        return interactor.getCredits();
    }

    /**
     * Gets items in inven
     * @return list of items in inventory of a player
     */
    public List<InvenItem> getInvenItems() {
        List<InvenItem> itemList = new ArrayList<>();
        for (Tradable good : interactor.getInventorySet()) {
            itemList.add(new InvenItem(good.getName(), interactor.amountOf(good)));
        }
        return itemList;
    }
}