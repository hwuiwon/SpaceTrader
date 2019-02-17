package edu.gatech.cs2340.team49x.spacetrader.Objects;

public enum Difficulty {
    EASY, NORMAL, HARD, IMPOSSIBLE;
    private static Difficulty[] vals = values();

    public String next() {
        return vals[(this.ordinal() + 1) % vals.length].toString();
    }

    public String prev() {
        return vals[(this.ordinal() - 1) % vals.length].toString();
    }
}