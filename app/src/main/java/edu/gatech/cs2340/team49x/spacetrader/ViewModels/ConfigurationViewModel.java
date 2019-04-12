package edu.gatech.cs2340.team49x.spacetrader.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;

/**
 * ViewModel used for ConfigurationActivity
 */
public class ConfigurationViewModel extends AndroidViewModel {

    /**
     * Default Constructor
     * @param application application
     */
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Configures ConfigurationViewModel
     * @param p current player
     * @param d current game difficulty
     */
    public void configure(Player p, Difficulty d) {
        ModelFacade.getInstance().configureGame(p, d);
    }

    /**
     * Gets player
     * @return current player
     */
    public Player getPlayer() {
        return ModelFacade.getInstance().getPlayer();
    }

    /**
     * Gets difficulty
     * @return current difficulty
     */
    public Difficulty getDifficulty() {
        return ModelFacade.getInstance().getDifficulty();
    }

    /**
     * Prints current state of a game
     */
    public void printGameState() {
        Log.e("STATE", ModelFacade.getInstance().printPlayer());
    }
}