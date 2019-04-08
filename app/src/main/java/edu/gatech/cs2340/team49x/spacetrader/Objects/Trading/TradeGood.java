package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import java.util.Random;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Resources;
import edu.gatech.cs2340.team49x.spacetrader.Objects.TechLevel;

/**
 * Items that are sold in solar systems
 */
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

    /**
     * Initializes the price of this good on a system with a give tech level and resources
     * @param techLevel the tech level of the system
     * @param resources the resources of the system
     * @return the price of the good on the system, randomized with variance
     */
    public int initPrice(TechLevel techLevel, Resources resources) {
        int price = basePrice;
        price += priceIcrTech * (techLevel.ordinal() - minTechProduce);
        Random random = new Random();
        if (random.nextBoolean()){
            price += random.nextInt(variance + 1);
        } else {
            price -= random.nextInt(variance + 1);
        }
        if (resources == lowWhenPresent) {
            price /= 2;
        } else if (resources == highWhenPresent) {
            price *= 2 + random.nextInt(2);
        }
        return price;
    }

    /**
     * Checks if item can be produced in current solar system
     * @param techLevel current tech level
     * @return if item can be produced in current tech level
     */
    public boolean canBeProducedBy(TechLevel techLevel) {
        return techLevel.ordinal() >= this.minTechProduce;
    }

    /**
     * Checks if item can be used in current solar system
     * @param techLevel current tech level
     * @return whether item can be used
     */
    public boolean canBeUsedBy(TechLevel techLevel) {
        return techLevel.ordinal() >= this.minTechUse;
    }

// --Commented out by Inspection START (4/8/2019 6:20 PM):
//    /**
//     * Minimum tech level to produce
//     * @return int value of tech level
//     */
//    public int getMinTechProduce() {
//        return minTechProduce;
//    }
// --Commented out by Inspection STOP (4/8/2019 6:20 PM)

    /**
     * Get name
     * @return name of an item
     */
    @Override
    public String getName() {
        return name;
    }

// --Commented out by Inspection START (4/8/2019 6:20 PM):
//// --Commented out by Inspection START (4/8/2019 6:20 PM):
////    /**
////     * Gets base price of an item
// --Commented out by Inspection START (4/8/2019 6:20 PM):
//////     * @return base price of an item
//////     */
//////    public int getBasePrice() {
//// --Commented out by Inspection STOP (4/8/2019 6:20 PM)
// --Commented out by Inspection STOP (4/8/2019 6:20 PM)
//        return basePrice;
//    }
// --Commented out by Inspection STOP (4/8/2019 6:20 PM)

// --Commented out by Inspection START (4/8/2019 6:27 PM):
//    /**
//     * Gets price change range
//     * @return price change range
//     */
// --Commented out by Inspection START (4/8/2019 6:27 PM):
////    public int getPriceIcrTech() {
////        return priceIcrTech;
////    }
//// --Commented out by Inspection STOP (4/8/2019 6:27 PM)
// --Commented out by Inspection STOP (4/8/2019 6:27 PM)

//    /**
//     * Gets variance
//     * @return variance
//     */
//    public int getVariance() {
//        return variance;
//    }

    /**
     * Gets condition
 --Commented out by Inspection START (4/8/2019 6:20 PM):
     * @return condition that makes price go up
     */
    public RandomCondition getPriceUP() {
        return priceUP;
    }
//
//    /**
//     * Gets resource
//// --Commented out by Inspection START (4/8/2019 6:20 PM):
// --Commented out by Inspection STOP (4/8/2019 6:20 PM)
//     * @return resource that are produced less
//     */
//    public Resources getLowWhenPresent() {
//        return lowWhenPresent;
//    }
// --Commented out by Inspection STOP (4/8/2019 6:20 PM)
//
// --Commented out by Inspection START (4/8/2019 6:27 PM):
//    /**
//     * Gets resource
//     * @return resource that are produced more
//     */
//    public Resources getHighWhenPresent() {
//        return highWhenPresent;
//    }
// --Commented out by Inspection STOP (4/8/2019 6:27 PM)
}