package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.TechLevel;

public enum TradeGood implements Tradable {

    WATER("Water", 0, 0, 30, 3, 4,
            RandomCondition.DROUGHT, Resources.LOTSOFWATER, Resources.DESERT),
    FURS("Furs", 0, 0, 250, 10, 10,
            RandomCondition.COLD, Resources.RICHFAUNA, Resources.LIFELESS),
    FOOD("Food", 1, 0, 100, 5, 5,
            RandomCondition.CROPFAIL, Resources.RICHSOIL, Resources.POORSOIL),
    ORE("Ore", 2, 2, 350, 20, 10,
            RandomCondition.WAR, Resources.MINERALRICH, Resources.MINERALPOOR),
    GAMES("Games", 3, 1, 250, -10, 5,
            RandomCondition.BOREDOM, Resources.ARTISTIC, null),
    FIREARMS("Firearms", 3, 1, 1250, -75, 100,
            RandomCondition.WAR, Resources.WARLIKE, null),
    MEDICINE("Medicine", 4, 1, 650, -20, 10,
            RandomCondition.PLAGUE, Resources.LOTSOFHERBS, null),
    MACHINES("Machines", 4, 3, 900, -30, 5,
            RandomCondition.LACKOFWORKERS, null, null),
    NARCOTICS("Narcotics", 5, 0, 3500, -125, 150,
            RandomCondition.BOREDOM, Resources.WEIRDMUSHROOMS, null),
    ROBOTS("Robots", 6, 4, 5000, -150, 100,
            RandomCondition.LACKOFWORKERS, null, null);

    private final String name;
    private final int minTechProduce;
    private final int minTechUse;
    private final int basePrice;
    private final int priceIcrTech;
    private final int variance;
    private final RandomCondition priceUP;
    private final Resources lowWhenPresent;
    private final Resources highWhenPresent;

    TradeGood(String name, int minTechProduce, int minTechUse,
              int basePrice, int priceIcrTech, int variance, RandomCondition priceUP,
              Resources lowWhenPresent, Resources highWhenPresent) {
        this.name = name;
        this.minTechProduce = minTechProduce;
        this.minTechUse = minTechUse;
        this.basePrice = basePrice;
        this.priceIcrTech = priceIcrTech;
        this.variance = variance;
        this.priceUP = priceUP;
        this.lowWhenPresent = lowWhenPresent;
        this.highWhenPresent = highWhenPresent;
    }

    public boolean canBeProducedBy(TechLevel tl) {
        return tl.ordinal() >= this.minTechProduce;
    }

    public boolean canBeUsedBy(TechLevel tl) {
        return tl.ordinal() >= this.minTechUse;
    }

    public int getMinTechProduce() {
        return minTechProduce;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getPriceIcrTech() {
        return priceIcrTech;
    }

    public int getVariance() {
        return variance;
    }

    public RandomCondition getPriceUP() {
        return priceUP;
    }

    public Resources getLowWhenPresent() {
        return lowWhenPresent;
    }

    public Resources getHighWhenPresent() {
        return highWhenPresent;
    }

}