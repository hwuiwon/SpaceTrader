package edu.gatech.cs2340.team49x.spacetrader.Objects;

public class Game {
    private Player player;
    private Difficulty difficulty;

    public Player getPlayerInfo() {
        if (player == null) {
            return null;
        }
        Player newPlayer = new Player(
                player.getName(),
                player.getSkillPt(),
                player.getPilotPt(),
                player.getFighterPt(),
                player.getTradePt(),
                player.getEngineerPt(),
                player.getShip()
        );
        return newPlayer;
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

    @Override
    public String toString() {
        return "Game{" +
                "player=" + player +
                ", difficulty=" + difficulty +
                '}';
    }
}
