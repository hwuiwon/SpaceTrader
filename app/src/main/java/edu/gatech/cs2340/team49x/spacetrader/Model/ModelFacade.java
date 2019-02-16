package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Player;

public class ModelFacade {
    private static ModelFacade instance = new ModelFacade();

    public static ModelFacade getInstance() { return instance; }

    private Game game;

    private ModelFacade() {
        game = new Game();
    }

    public void configureGame(Player p, Difficulty d) {
        game.configurePlayer(p);
        game.setDifficulty(d);
    }

    public String printGameState() {
        return game.toString();
    }

    public Game getGame() {
        return game;
    }
}
