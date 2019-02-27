package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Map;

public class PriceList {
    private Map<TradeGood, Integer> prices;

    /**
     * Returns the unit price of a good
     * @param good the good to test
     * @return the price of the good
     */
    public int priceOf(TradeGood good) {
        if (prices.containsKey(good)) {
            return prices.get(good);
        }
        return 0;
    }
}
