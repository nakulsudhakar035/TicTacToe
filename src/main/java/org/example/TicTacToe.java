package org.example;

import org.example.controller.GameController;
import org.example.exception.InvalidDimensionException;
import org.example.exception.InvalidPlayerCountException;
import org.example.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Hello, enter the dimension of the board");
        Scanner scanner = new Scanner(System.in);
        int dimension = scanner.nextInt();

        int playerCount = dimension-1;
        System.out.println("Are you playing against a bot ? (Y,N)");
        char isBot = scanner.next().toUpperCase().charAt(0);

        List<Player> players = new ArrayList<>();
        if(isBot=='Y'){
            playerCount--;
            System.out.println("Enter the name of Bot");
            String name = scanner.next();

            System.out.println("Enter the symbol for bot");
            char symbol = scanner.next().charAt(0);

            players.add(new Bot(symbol, name, PlayerType.BOT, BotDifficultyLevel.EASY));
            for(int i = 0; i < playerCount; i++){
                System.out.println("Enter the name of player " + (i+1));
                name = scanner.next();

                System.out.println("Enter the symbol for player " + (i+1));
                symbol = scanner.next().charAt(0);

                players.add(new Player(symbol, name, PlayerType.HUMAN));
            }
        }
        GameController gameController = new GameController();
        Game game = null;
        try {
            game = gameController.createGame(dimension,players);
        } catch (InvalidDimensionException e) {
            System.out.println("Please ensure the dimension of the board is atleast 3");
        } catch (InvalidPlayerCountException e) {
            System.out.println("Please ensure the players count are " + (dimension-1));
        }
        while(game != null && game.getGameStatus() == GameStatus.INPROGRESS) {
            gameController.showBoard(game);
            System.out.println("Do you want to undo ? (Y,N)");
            char isUndo = scanner.next().toUpperCase().charAt(0);
            if (isUndo == 'Y') {
                gameController.undo();
            }
            gameController.makeNextMove(game);

        }

        if(game.getWinner()==null){
            System.out.println("Game has ended in a draw");
        } else {
            System.out.println("Game is won by "+ game.getWinner().getName());
        }

    }
}
