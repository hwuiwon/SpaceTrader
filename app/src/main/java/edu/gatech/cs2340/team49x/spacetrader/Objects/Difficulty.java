package edu.gatech.cs2340.team49x.spacetrader.Objects;

public enum Difficulty {
    EASY, NORMAL, HARD, IMPOSSIBLE;
    private static Difficulty[] values = values();

    public String next() {
        return values[(this.ordinal() + 1) % values.length].toString();
    }

    public String prev() {
        if (this.ordinal() - 1 < 0) {
            return values[Math.abs((this.ordinal() - values.length + 1) % values.length)].toString();
        }
        return values[(this.ordinal() - 1) % values.length].toString();
    }
}