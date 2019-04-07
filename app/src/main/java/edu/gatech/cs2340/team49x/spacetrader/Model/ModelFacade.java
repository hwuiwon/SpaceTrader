package edu.gatech.cs2340.team49x.spacetrader.Model;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;

/**
 * Used for backend
 */
public final class ModelFacade {

    private static final int NUM_SYSTEMS = 100;
    private static final String SAVE_NAME = "game.ser";
    private static final ModelFacade instance = new ModelFacade();

    private final TradeInteractor tradeInteractor = new TradeInteractor();
    private final CurrentSystemInteractor systemInteractor = new CurrentSystemInteractor();
    private final PlayerInteractor playerInteractor = new PlayerInteractor();

    /**
     * Gets current game instance
     * @return instance
     */
    public static ModelFacade getInstance() { return instance; }

    private Game game;

    private ModelFacade() {
        game = new Game();
    }

    /**
     * Check if game is configured
     * @return result
     */
    public boolean gameConfigured() {
        return game.getPlayer() != null;
    }

    /**
     * Configures game
     * @param player current player
     * @param difficulty difficulty of a game
     */
    public void configureGame(Player player, Difficulty difficulty) {
        game = new Game(player, difficulty, NUM_SYSTEMS);
    }

    /**
     * Saves game
     * @param context context
     * @throws IOException when necessary
     */
    public void saveGame(Context context) throws IOException {
        FileOutputStream file = context.openFileOutput(SAVE_NAME, Context.MODE_PRIVATE);
        ObjectOutput out = new ObjectOutputStream(file);
        out.writeObject(game);
        out.close();
        file.close();
    }

    /**
     * Loads game
     * @param context context
     * @throws IOException when necessary
     * @throws ClassNotFoundException when necessary
     */
    public void loadGame(Context context) throws IOException, ClassNotFoundException {
        FileInputStream file = context.openFileInput(SAVE_NAME);
        ObjectInputStream in = new ObjectInputStream(file);
        game = (Game) in.readObject();
        in.close();
        file.close();
    }

    /**
     * Gets player
     * @return current player
     */
    public Player getPlayer() {
        return  game.getPlayer();
    }

    /**
     * Gets difficulty
     * @return current difficulty
     */
    public Difficulty getDifficulty() {
        return  game.getDifficulty();
    }

    /**
     * Prints player
     * @return player information
     */
    public String printPlayer() {
        return game.printPlayer();
    }

    /**
     * Starts trade
     * @return TradeInteractor
     */
    public TradeInteractor startTrade() {
        tradeInteractor.init(game.getCurrentSystem());
        return tradeInteractor;
    }

    /**
     * Gets SystemInteractor
     * @return CurrentSystemInteractor
     */
    public CurrentSystemInteractor getSystemInteractor() {
        systemInteractor.init(game);
        return systemInteractor;
    }

    /**
     * Gets PlayerInterActor
     * @return PlayerInteractor
     */
    public PlayerInteractor getPlayerInteractor() {
        playerInteractor.init(game.getPlayer());
        return playerInteractor;
    }
}