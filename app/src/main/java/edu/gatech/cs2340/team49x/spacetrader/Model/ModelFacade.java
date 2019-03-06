package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

public class ModelFacade {
    private final static int NUM_SYSTEMS = 100;
    private static ModelFacade instance = new ModelFacade();

    public static ModelFacade getInstance() { return instance; }

    private Game game;

    private ModelFacade() {
        game = new Game();
    }

    public void configureGame(Player player, Difficulty difficulty) {
        game = new Game(player, difficulty, NUM_SYSTEMS);
    }

    public Player getPlayer() {
        return  game.getPlayer();
    }

    public Universe getUniverse() {
        return game.getUniverse();
    }

    public Difficulty getDifficulty() {
        return  game.getDifficulty();
    }

    public String printPlayer() {
        return game.printPlayer();
    }

    public TradeInteractor startTrade() {
        return new TradeInteractor(game.getPlayer(), game.getCurrentSystem());
    }

    public String printUniverse() {
        return game.printUniverse();
    }
}