package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Game {
    private Player player;
    private Difficulty difficulty;

    public void configurePlayer(Player p) {
        player = p;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}
