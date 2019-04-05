package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;

public class MainViewModel extends AndroidViewModel {

    private final Context appContext;

    public MainViewModel(@NonNull Application application) {
        super(application);
        appContext = application.getApplicationContext();
    }

    /**
     * Checks if game is configured
     * @return true if there is configured game or false
     */
    public boolean gameConfigured() {
        return ModelFacade.getInstance().gameConfigured();
    }

    /**
     * Loads game from saved data
     * @throws IOException exception
     * @throws ClassNotFoundException exception
     */
    public void loadGame() throws IOException, ClassNotFoundException {
        ModelFacade.getInstance().loadGame(appContext);
    }

    /**
     * Saves current game progress
     */
    public void saveGame() {
        try {
            ModelFacade.getInstance().saveGame(appContext);
            Log.d("GAME", "Game saved.");
        } catch (IOException e) {
            Log.e("GAME", "Failed to save game.", e);
        }
    }
}
