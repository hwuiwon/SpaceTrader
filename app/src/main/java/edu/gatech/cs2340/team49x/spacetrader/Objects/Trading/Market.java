package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.TechLevel;

public class Market implements Trader {

    private final Map<TradeGood, Integer> prices;
    private RandomCondition condition;
    private Tradable[] sells = {};
    private Tradable[] buys = {};

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
                int price = good.getBasePrice();

                price += good.getPriceIcrTech() * (techLevel.ordinal() - good.getMinTechProduce());
                Random random = new Random();
                if (random.nextBoolean()){
                    price += random.nextInt(good.getVariance() + 1);
                } else {
                    price -= random.nextInt(good.getVariance() + 1);
                }
                if (resources == good.getLowWhenPresent()) {
                    price /= 2;
                } else if (resources == good.getHighWhenPresent()) {
                    price *= 2 + random.nextInt(2);
                }
                prices.put(good, price);
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
        return sells;
    }

    /**
     * Items player can buy on that Market
     * @return list of items
     */
    @Override
    public Tradable[] buys() {
        return buys;
    }

    /**
     * Determines price of an item
     * @param t Tradable
     * @return price of an item
     */
    @Override
    public int getPrice(Tradable t) {
        if (prices.containsKey(t)) {
            TradeGood good = (TradeGood) t;
            if (good.getPriceUP() == condition) {
                return prices.get(t) * 4;
            }
            return prices.get(t);
        }
        return 0;
    }
}