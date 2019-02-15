package edu.gatech.cs2340.team49x.spacetrader.Model;

import edu.gatech.cs2340.team49x.spacetrader.Objects.Game;

public class ModelFacade {
    private static ModelFacade instance = new ModelFacade();

    public static ModelFacade getInstance() { return instance; }

    private Game game;

    private ModelFacade() {
        createGame();
    }

    public void createGame() {
        game = new Game();
    }

}
