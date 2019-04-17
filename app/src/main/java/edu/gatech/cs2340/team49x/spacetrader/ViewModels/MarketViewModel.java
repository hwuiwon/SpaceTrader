package edu.gatech.cs2340.team49x.spacetrader.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.PlayerInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Model.TradeInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;
import edu.gatech.cs2340.team49x.spacetrader.ViewObjects.Item;

/**
 * ViewModel used for MarketActivity
 */
public class MarketViewModel extends AndroidViewModel {

    /**
     * Default constructor
     * @param application application
     */
    public MarketViewModel(@NonNull Application application) {
        super(application);
        selectedGoods = new Inventory();
    }

    private Item[] sellItems = {};
    private Item[] buyItems = {};
    private Inventory selectedGoods;
    private TradeInteractor tradeInteractor;
    private PlayerInteractor playerInteractor;
    private boolean buying = true;
    private int total;

    /**
     * Initialize MarketViewModel
     */
    public void init() {
        ModelFacade mf = ModelFacade.getInstance();
        tradeInteractor = mf.startTrade();
        playerInteractor = mf.getPlayerInteractor();
        selectedGoods = new Inventory();
        total = 0;

        List<Item> sellList = new ArrayList<>();
        List<Item> buyList = new ArrayList<>();

        for (Tradable t : tradeInteractor.getBuyList()) {
            sellList.add(new Item(
                    t.getName(),
                    tradeInteractor.getPriceOf(t),
                    playerInteractor.getCargoAmount(t)
            ));
        }
        for (Tradable t : tradeInteractor.getSellList()) {
            buyList.add(new Item(
                    t.getName(),
                    (int) (tradeInteractor.getPriceOf(t) * playerInteractor.getTradePt()),
                    playerInteractor.getCargoAmount(t)
            ));
        }

        sellItems = sellList.toArray(sellItems);
        buyItems = buyList.toArray(buyItems);
    }

    /**
     * Gets list of items depending on current transaction mode
     * @return item array
     */
    public Item[] getItems() {
        return buying ? buyItems : sellItems;
    }

    /**
     * Increments the amount of a good selected
     * @param name the Tradable selected
     */
    public void increaseAmount(String name) {
        Tradable good = tradeInteractor.getTradable(name);
        if (buying) {
            if (selectedGoods.getCount() >= playerInteractor.getCargoRemaining()) {
                return;
            }
        } else if (selectedGoods.getQuantity(good) >= playerInteractor.getCargoAmount(good)) {
            return;
        }
        selectedGoods.add(good, 1);
        total += tradeInteractor.getPriceOf(good);
    }

    /**
     * Decreases amount of selected item
     * @param name item that player selected
     */
    public void decreaseAmount(String name) {
        Tradable good = tradeInteractor.getTradable(name);
        if (selectedGoods.getQuantity(good) > 0) {
            selectedGoods.add(good, -1);
            total -= tradeInteractor.getPriceOf(good);
        }
    }

    /**
     * Changes transaction mode
     */
    public void toggleBuySell() {
        buying = !buying;
        selectedGoods.empty();
        total = 0;
    }

    /**
     * Gets number of selected item
     * @param name item
     * @return number of selected item
     */
    public int getAmountSelected(String name) {
        Tradable good = tradeInteractor.getTradable(name);
        return selectedGoods.getQuantity(good);
    }

    /**
     * Gets items in cargo
     * @param name type of item
     * @return number of good that player owns
     */
    public int getCargo(String name) {
        Tradable good = tradeInteractor.getTradable(name);
        return playerInteractor.getCargoAmount(good);
    }

    /**
     * Checks if player is buying
     * @return true if player is buying or false if selling
     */
    public boolean isBuying() {
        return buying;
    }

    /**
     * Gets total value
     * @return total value of items player selected
     */
    public int getTotal() {
        return total;
    }

    /**
     * Gets credits
     * @return total credits of current player
     */
    public int getCredits() {
        return playerInteractor.getCredits();
    }

    /**
     * Performs transaction
     */
    public void done() {
        if (buying) {
            if (selectedGoods != null) {
                playerInteractor.addToCargo(selectedGoods);
                playerInteractor.changeCredits(-total);
            }
        } else {
            if (selectedGoods != null) {
                playerInteractor.removeFromCargo(selectedGoods);
                playerInteractor.changeCredits(total);
            }
        }
        if (selectedGoods != null) {
            selectedGoods.empty();
        }
        total = 0;
        try {
            ModelFacade.getInstance().saveGame(getApplication().getApplicationContext());
            Log.d("GAME", "Game saved.");
        } catch (IOException e) {
            Log.e("GAME", "Failed to save game.", e);
        }
    }
}