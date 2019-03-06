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
    private Tradable[] sells = null;
    private Tradable[] buys = null;

    public Market(TechLevel techLevel, Resources resources, Random random) {
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
        if (sells != null) sells = canSell.toArray(sells);
        if (buys != null) buys = canBuy.toArray(buys);
    }

    public RandomEvent getEvent() {
        return event;
    }

    public void setEvent(RandomEvent event) {
        this.event = event;
    }

    @Override
    public Tradable[] sells() {
        return sells;
    }

    @Override
    public Tradable[] buys() {
        return buys;
    }

    @Override
    public int getPrice(Tradable t) {
        if (prices.containsKey(t)) {
            TradeGood good = (TradeGood) t;
            if (good.getPriceUP() == event) {
                return prices.get(t) * 2;
            }
            return prices.get(t);
        }
        return 0;
    }
}