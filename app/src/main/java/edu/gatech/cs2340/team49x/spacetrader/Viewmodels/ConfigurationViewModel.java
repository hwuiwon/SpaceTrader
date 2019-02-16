package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.view.Display;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Game;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Player;

public class ConfigurationViewModel extends AndroidViewModel {
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    public void configure(Player p, Difficulty d) {
        ModelFacade.getInstance().configureGame(p, d);
    }

    public String printGameState() {
        return ModelFacade.getInstance().printGameState();
    }

    public Difficulty getDifficulty() {
        return ModelFacade.getInstance().getGame().getDifficulty();
    }
}
