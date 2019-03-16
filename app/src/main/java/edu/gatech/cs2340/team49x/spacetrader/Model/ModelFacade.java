package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

public class ModelFacade {

    private final static int NUM_SYSTEMS = 100;
    private static ModelFacade instance = new ModelFacade();

    private TradeInteractor tradeInteractor = new TradeInteractor();
    private CurrentSystemInteractor systemInteractor = new CurrentSystemInteractor();
    private PlayerInteractor playerInteractor = new PlayerInteractor();

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

    public SolarSystem getCurrentSystem() {
        return game.getCurrentSystem();
    }

    public void setCurrentSystem(SolarSystem system) {
        game.setCurrentSystem(system);
    }

    public String printPlayer() {
        return game.printPlayer();
    }

    public TradeInteractor startTrade() {
        tradeInteractor.init(game.getPlayer(), game.getCurrentSystem());
        return tradeInteractor;
    }

    public CurrentSystemInteractor getSystemInteractor() {
        systemInteractor.init(game);
        return systemInteractor;
    }

    public PlayerInteractor getPlayerInteractor() {
        playerInteractor.init(game.getPlayer());
        return playerInteractor;
    }

    public String printUniverse() {
        return game.printUniverse();
    }
}