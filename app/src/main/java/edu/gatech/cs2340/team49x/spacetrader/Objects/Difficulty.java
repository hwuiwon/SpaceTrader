package edu.gatech.cs2340.team49x.spacetrader.Objects;

/**
 * Difficulty of a game
 */
public enum Difficulty {

    EASY,
    NORMAL,
    HARD,
    IMPOSSIBLE;

    private static final Difficulty[] values = values();

    /**
     * Gets next difficulty
     * @return name of next difficulty
     */
    public String next() {
        return values[(this.ordinal() + 1) % values.length].toString();
    }

    /**
     * Gets previous difficulty
     * @return name of previous difficulty
     */
    public String prev() {
        if ((this.ordinal() - 1) < 0) {
            return values[Math.abs(
                    ((this.ordinal() - values.length) + 1) % values.length)].toString();
        }
        return values[(this.ordinal() - 1) % values.length].toString();
    }
}