package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;

public class MainViewModel extends AndroidViewModel {
    private Context appContext;
    public MainViewModel(@NonNull Application application) {
        super(application);
        appContext = application.getApplicationContext();
    }

    public boolean gameConfigured() {
        return ModelFacade.getInstance().gameConfigured();
    }

    public void loadGame() throws IOException, ClassNotFoundException {
        ModelFacade.getInstance().loadGame(appContext);
    }


    public void saveGame() {
        try {
            ModelFacade.getInstance().saveGame(appContext);
            Log.d("GAME", "Game saved.");
        } catch (IOException e) {
            Log.e("GAME", "Failed to save game.", e);
        }
    }
}
