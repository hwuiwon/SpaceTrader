package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.TechLevel;

/**
 * Market class for MarketActivity
 */
public class Market implements Trader {

    private final Map<TradeGood, Integer> prices;
    private RandomCondition condition;
    private Tradable[] sells = {};
    private Tradable[] buys = {};

    /**
     * Default constructor to set-up market
     * @param techLevel tech level of current system
     * @param resources resources in current system
     */
    public Market(TechLevel techLevel, Resources resources) {
        List<Tradable> canSell = new ArrayList<>();
        List<Tradable> canBuy = new ArrayList<>();
        prices = new HashMap<>();
        for (TradeGood good : TradeGood.values()) {
            if (good.canBeProducedBy(techLevel)) {
                canSell.add(good);
            }
            if (good.canBeUsedBy(techLevel)) {
                canBuy.add(good);
                prices.put(good, good.initPrice(techLevel, resources));
            }
        }
        sells = canSell.toArray(sells);
        buys = canBuy.toArray(buys);
    }

    /**
     * Sets condition of Market
     * @param condition random condition
     */
    public void setCondition(RandomCondition condition) {
        this.condition = condition;
    }

    /**
     * Items that market can sell
     * @return list of items
     */
    @Override
    public Tradable[] sells() {
        return sells.clone();
    }

    /**
     * Items player can buy on that Market
     * @return list of items
     */
    @Override
    public Tradable[] buys() {
        return buys.clone();
    }

    /**
     * Determines price of an item
     * @param t Tradable
     * @return price of an item
     */
    @Override
    public int getPrice(Tradable t) {
        if (!(t instanceof TradeGood)) {
            return 0;
        }
        TradeGood good = (TradeGood) t;
        Integer priceObj = prices.get(good);
        int price = (priceObj == null) ? 0 : priceObj;
        if (good.getPriceUP() == condition) {
            return price * 4;
        }
        return price;
    }
}