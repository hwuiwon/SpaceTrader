package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Model.TradeInteractor;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Item;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Inventory;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.Tradable;

public class MarketViewModel extends AndroidViewModel {
    public MarketViewModel(@NonNull Application application) {
        super(application);
    }

    private Item[] items;
    private Inventory selectedGoods;
    private TradeInteractor interactor;
    private boolean buying;
    private int total;

    public void init() {
        interactor = ModelFacade.getInstance().startTrade();
        selectedGoods.empty();
        total = 0;
        //initialize item array by getting data from the interactor
    }

    public Item[] getItems() {
        return items;
    }

    /**
     * Increments the amount of a good selected
     * @param good the Tradable selected
     * @return true if the increase was successful, false otherwise
     */
    public boolean increaseAmount(Tradable good) {
        if (buying) {
            if (selectedGoods.getCount() >= interactor.getCargoRemaining()) {
                return false;
            }
        } else if (selectedGoods.getQuantity(good) >= interactor.getCargoAmount(good)) {
            return false;
        }
        selectedGoods.add(good, 1);
        total += interactor.getPriceOf(good);
        return true;
    }

    public boolean decreaseAmount(Tradable good) {
        if (selectedGoods.getQuantity(good) <= 0) {
            return false;
        }
        selectedGoods.add(good, -1);
        total -= interactor.getPriceOf(good);
        return true;
    }

    public void toggleBuySell() {
        buying = !buying;
        selectedGoods.empty();
        total = 0;
    }

    public int getAmountSelected(Tradable good) {
        return selectedGoods.getQuantity(good);
    }

    public boolean isBuying() {
        return buying;
    }

    public int getTotal() {
        return total;
    }

    public void done() {
        if (buying) {
            interactor.addToCargo(selectedGoods);
            interactor.changeCredits(-total);
        } else {
            interactor.removeFromCargo(selectedGoods);
            interactor.changeCredits(total);
        }
        selectedGoods.empty();
        total = 0;
    }
}
