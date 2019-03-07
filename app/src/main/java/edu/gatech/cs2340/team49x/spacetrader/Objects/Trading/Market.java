package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.TechLevel;

public class Market implements Trader {
    private Map<TradeGood, Integer> prices;
    private RandomEvent event;
    private String[] sells = {};
    private String[] buys = {};
    private Random random = new Random();

    public Market(TechLevel techLevel, Resources resources) {
        List<TradeGood> canSell = new ArrayList<>();
        List<TradeGood> canBuy = new ArrayList<>();
        prices = new HashMap<>();
        for (TradeGood good : TradeGood.values()) {
            if (good.canBeProducedBy(techLevel)) {
                canSell.add(good);
            }
            if (good.canBeUsedBy(techLevel)) {
                canBuy.add(good);
                int price = good.getBasePrice();
                //Do price initialization stuff
                price += good.getPriceIcrTech() * (techLevel.ordinal() - good.getMinTechProduce());
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

    public RandomEvent getEvent() {
        return event;
    }

    public void setEvent(RandomEvent event) {
        this.event = event;
    }

    @Override
    public String[] sells() {
        return sells;
    }

    @Override
    public String[] buys() {
        return buys;
    }

    @Override
    public int getPrice(String t) {
        if (prices.containsKey(t)) {
            TradeGood good = TradeGood.valueOf(t);
            if (good.getPriceUP() == event) {
                return prices.get(t) * 2;
            }
            return prices.get(t);
        }
        return 0;
    }
}