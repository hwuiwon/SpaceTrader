package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;

public class ConfigurationViewModel extends AndroidViewModel {

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

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