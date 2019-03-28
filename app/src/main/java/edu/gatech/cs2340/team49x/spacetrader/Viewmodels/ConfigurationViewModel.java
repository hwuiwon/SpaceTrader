package edu.gatech.cs2340.team49x.spacetrader.Viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import edu.gatech.cs2340.team49x.spacetrader.Model.ModelFacade;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Difficulty;
import edu.gatech.cs2340.team49x.spacetrader.Objects.General.Player;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.SolarSystem;
import edu.gatech.cs2340.team49x.spacetrader.Objects.Universe.Universe;

public class ConfigurationViewModel extends AndroidViewModel {

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    public void configure(Player p, Difficulty d) {
        ModelFacade.getInstance().configureGame(p, d);
    }

    public Player getPlayer() {
        return ModelFacade.getInstance().getPlayer();
    }

    public Universe getUniverse() {
        return ModelFacade.getInstance().getUniverse();
    }

    public Difficulty getDifficulty() {
        return ModelFacade.getInstance().getDifficulty();
    }

    public SolarSystem getCurrentSystem() {
        return ModelFacade.getInstance().getCurrentSystem();
    }

    public void setCurrentSystem(SolarSystem system) {
        ModelFacade.getInstance().setCurrentSystem(system);
    }

    public void printGameState() {
        Log.e("STATE", ModelFacade.getInstance().printPlayer());
//        Log.e("STATE", ModelFacade.getInstance().printUniverse());
    }
}