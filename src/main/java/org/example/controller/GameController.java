package org.example.controller;

import org.example.exception.InvalidDimensionException;
import org.example.exception.InvalidPlayerCountException;
import org.example.model.Game;
import org.example.model.Player;

import java.util.List;

public class GameController {

    int dimension;
    List<Player> players;

    public Game createGame(int dimension, List<Player> players) throws InvalidDimensionException, InvalidPlayerCountException {

        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
    }

    public void undo() {
        // TODO: 09-09-2023
    }

    public void showBoard(Game game) {
        game.showBoard();
    }

    public void makeNextMove(Game game) {
        game.makeNextMove();
    }
}
