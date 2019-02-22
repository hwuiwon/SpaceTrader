package edu.gatech.cs2340.team49x.spacetrader.Objects;

public enum Resources {

    NOSPECIALRESOURCES(0), MINERALRICH(1), MINERALPOOR(2),
    DESERT(3), TSOFWATER(4), RICHSOIL(5), POORSOIL(6),
    RICHFAUNA(7), LIFELES(8), WEIRDMUSHROOMS(9), LOTSOFHERBS(10),
    ARTISTIC(11), WARLIKE(12);

    private int i;

    Resources(int i) {
        this.i = i;
    }

    public Resources getResource(int i) {
        return Resources.values()[i];
    }
}