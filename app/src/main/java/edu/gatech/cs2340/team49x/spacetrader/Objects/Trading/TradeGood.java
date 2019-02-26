package edu.gatech.cs2340.team49x.spacetrader.Objects.Trading;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Resources;

public enum TradeGood {
    WATER("Water", 0, 0, 2, 30, 3, 4, RandomEvent.DROUGHT, Resources.LOTSOFWATER, Resources.DESERT, 30, 50),
    FURS("Furs", 0, 0, 0, 250, 10, 10, RandomEvent.COLD, Resources.RICHFAUNA, Resources.LIFELESS, 230, 280),
    FOOD("Food", 1, 0, 1, 100, 5, 5, RandomEvent.CROPFAIL, Resources.RICHSOIL, Resources.POORSOIL, 90, 160),
    ORE("Ore", 2, 2, 3, 350, 20, 10, RandomEvent.WAR, Resources.MINERALRICH, Resources.MINERALPOOR, 350, 420),
    GAMES("Games", 3, 1, 6, 250, -10, 5, RandomEvent.BOREDOM, Resources.ARTISTIC, null, 160, 270),
    FIREARMS("Firearms", 3, 1, 5, 1250, -75, 100, RandomEvent.WAR, Resources.WARLIKE, null, 600, 1100),
    MEDICINE("Medicine", 4, 1, 6, 650, -20, 10, RandomEvent.PLAGUE, Resources.LOTSOFHERBS, null, 400, 700),
    MACHINES("Machines", 4, 3, 5, 900, -30, 5, RandomEvent.LACKOFWORKERS, null, null, 600, 800),
    NARCOTICS("Narcotics", 5, 0, 5, 3500, -125, 150, RandomEvent.BOREDOM, Resources.WEIRDMUSHROOMS, null, 2000, 3000),
    ROBOTS("Robots", 6, 4, 7, 5000, -150, 100, RandomEvent.LACKOFWORKERS, null, null, 3500, 5000);

    private String name;
    private int mtlp;
    private int mtlu;
    private int ttp;
    private int basePrice;
    private int ipl;
    private int var;
    private RandomEvent ie;
    private Resources cr;
    private Resources er;
    private int mtl;
    private int mth;

    TradeGood(String name, int mtlp, int mtlu, int ttp, int basePrice, int ipl, int var,
              RandomEvent ie, Resources cr, Resources er, int mtl, int mth) {
        this.name = name;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.basePrice = basePrice;
        this.ipl = ipl;
        this.var = var;
        this.ie = ie;
        this.cr = cr;
        this.er = er;
        this.mtl = mtl;
        this.mth = mth;
    }
}
