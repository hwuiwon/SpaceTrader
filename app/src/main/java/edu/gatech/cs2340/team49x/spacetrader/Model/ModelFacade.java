package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Trading.TradeTransaction;

public class ModelFacade {
    private final static int NUM_SYSTEMS = 100;
    private static ModelFacade instance = new ModelFacade();

    public static ModelFacade getInstance() { return instance; }

    private Game game;

    private ModelFacade() {
        game = new Game();
    }

    public void configureGame(Player p, Difficulty d) {
        game.setPlayer(p);
        game.setDifficulty(d);
        game.createUniverse(NUM_SYSTEMS);
    }

    public Player getPlayer() {
        return  game.getPlayerInfo();
    }

    public Difficulty getDifficulty() {
        return  game.getDifficulty();
    }

    public String printPlayer() {
        return game.printPlayer();
    }

    public TradeTransaction startTrade() {
        return game.startTrade();
    }

    public String printUniverse() {
        return game.printUniverse();
    }
}