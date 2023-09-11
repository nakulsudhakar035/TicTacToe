package org.example.model;

import java.util.Scanner;

public class Player {
    char symbol;
    String name;
    PlayerType playerType;

    public Player(char symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeNextMove(Board board) {
        System.out.println("Please enter the row index");
        Scanner scanner = new Scanner(System.in);
        int rowNo = scanner.nextInt();

        System.out.println("Please enter the col index");
        int colNo = scanner.nextInt();

        return new Move(this, new Cell(rowNo, colNo, CellState.MARKED, this));
    }
}
