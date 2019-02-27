package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Map;

public class PriceList {
    private Map<TradeGood, Integer> prices;

    public int priceOf(TradeGood good) {
        if (prices.containsKey(good)) {
            return prices.get(good);
        }
        return 0;
    }
}
