package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.TradeInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.Item;

public class MarketViewModel extends AndroidViewModel {

    private Context appContext;

    public MarketViewModel(@NonNull Application application) {
        super(application);
        appContext = application.getApplicationContext();
        selectedGoods = new Inventory();
    }

    private Item[] sellItems = {};
    private Item[] buyItems = {};
    private Inventory selectedGoods;
    private TradeInteractor interactor;
    private boolean buying = true;
    private int total;

    public void init() {
        interactor = ModelFacade.getInstance().startTrade();
        selectedGoods = new Inventory();
        total = 0;

        //initialize item array by getting data from the interactor
        List<Item> sellList = new ArrayList<>();
        List<Item> buyList = new ArrayList<>();

        for (Tradable t : interactor.getBuyList()) {
            sellList.add(new Item(
                    t,
                    interactor.getPriceOf(t),
                    interactor.getCargoAmount(t)
            ));
        }
        for (Tradable t : interactor.getSellList()) {
            buyList.add(new Item(
                    t,
                    interactor.getPriceOf(t),
                    interactor.getCargoAmount(t)
            ));
        }

        sellItems = sellList.toArray(sellItems);
        buyItems = buyList.toArray(buyItems);
    }

    public Item[] getItems() {
        return buying ? buyItems : sellItems;
    }

    /**
     * Increments the amount of a good selected
     * @param good the Tradable selected
     */
    public void increaseAmount(Tradable good) {
        if (buying) {
            if (selectedGoods.getCount() >= interactor.getCargoRemaining()) {
                return;
            }
        } else if (selectedGoods.getQuantity(good) >= interactor.getCargoAmount(good)) {
            return;
        }
        selectedGoods.add(good, 1);
        total += interactor.getPriceOf(good);
    }

    public void decreaseAmount(Tradable good) {
        if (selectedGoods.getQuantity(good) > 0) {
            selectedGoods.add(good, -1);
            total -= interactor.getPriceOf(good);
        }
    }

    public void toggleBuySell() {
        buying = !buying;
        selectedGoods.empty();
        total = 0;
    }

    public int getAmountSelected(Tradable good) {
        return selectedGoods.getQuantity(good);
    }

    public int getCargo(Tradable good) {
        return interactor.getCargoAmount(good);
    }

    public boolean isBuying() {
        return buying;
    }

    public int getTotal() {
        return total;
    }

    public int getCredits() {
        return interactor.getCredits();
    }

    public void done() {
        if (buying) {
            if (selectedGoods != null) {
                interactor.addToCargo(selectedGoods);
                interactor.changeCredits(-total);
            }
        } else {
            if (selectedGoods != null) {
                interactor.removeFromCargo(selectedGoods);
                interactor.changeCredits(total);
            }
        }
        if (selectedGoods != null) selectedGoods.empty();
        total = 0;
        try {
            ModelFacade.getInstance().saveGame(appContext);
            Log.d("GAME", "Game saved.");
        } catch (IOException e) {
            Log.e("GAME", "Failed to save game.", e);
        }
    }
}