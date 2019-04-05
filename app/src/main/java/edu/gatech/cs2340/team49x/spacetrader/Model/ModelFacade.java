package edu.gatech.cs2340.team49x.spacetrader.Model;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;

public final class ModelFacade {

    private final static int NUM_SYSTEMS = 100;
    private final static String SAVE_NAME = "game.ser";
    private static final ModelFacade instance = new ModelFacade();

    private final TradeInteractor tradeInteractor = new TradeInteractor();
    private final CurrentSystemInteractor systemInteractor = new CurrentSystemInteractor();
    private final PlayerInteractor playerInteractor = new PlayerInteractor();

    public static ModelFacade getInstance() { return instance; }

    private Game game;

    private ModelFacade() {
        game = new Game();
    }

    public boolean gameConfigured() {
        return game.getPlayer() != null;
    }

    public void configureGame(Player player, Difficulty difficulty) {
        game = new Game(player, difficulty, NUM_SYSTEMS);
    }

    public void saveGame(Context context) throws IOException {
        FileOutputStream file = context.openFileOutput(SAVE_NAME, Context.MODE_PRIVATE);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(game);
        out.close();
        file.close();
    }

    public void loadGame(Context context) throws IOException, ClassNotFoundException {
        FileInputStream file = context.openFileInput(SAVE_NAME);
        ObjectInputStream in = new ObjectInputStream(file);
        game = (Game) in.readObject();
        in.close();
        file.close();
    }

    public Player getPlayer() {
        return  game.getPlayer();
    }

    public Difficulty getDifficulty() {
        return  game.getDifficulty();
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
}