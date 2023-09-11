package org.example.model;

import org.example.exception.InvalidDimensionException;
import org.example.exception.InvalidPlayerCountException;
import org.example.stratergy.windetectionstratergy.ByRowColDiaWinDetectionStratergy;
import org.example.stratergy.windetectionstratergy.WinDetectionStratergy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Game {
    Board board;
    List<Move> moves;
    List<Player> players;
    Player winner;
    int nextPlayerIndex;
    WinDetectionStratergy winDetectionStratergy;

    GameStatus gameStatus;

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public WinDetectionStratergy getWinDetectionStratergy() {
        return winDetectionStratergy;
    }

    public void setWinDetectionStratergy(WinDetectionStratergy winDetectionStratergy) {
        this.winDetectionStratergy = winDetectionStratergy;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public void showBoard() {
        board.displayBoard();
    }

    public void makeNextMove() {
        Player player = players.get(nextPlayerIndex);
        System.out.println("This is " + player.getName()+"'s move");

        Move move = player.makeNextMove(board);

        int rowNo = move.cell.rowNo;
        int colNo = move.cell.colNo;

        board.cells.get(rowNo).get(colNo).setCellState(CellState.MARKED);
        board.cells.get(rowNo).get(colNo).setPlayer(player);

        this.moves.add(move);

        if(winDetectionStratergy.checkIfMatchPoint(board, player, move.cell)){
            gameStatus=GameStatus.WON;
            winner=player;
        }
        nextPlayerIndex++;
        nextPlayerIndex=nextPlayerIndex%players.size();
    }

    public static class Builder {

        int dimension;
        List<Player> players;



        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public boolean isValid() throws InvalidDimensionException, InvalidPlayerCountException {
            if(dimension < 3){
                throw new InvalidDimensionException("Dimension is less than 3");
            }
            if(players.size()!=dimension-1){
                throw new InvalidPlayerCountException("Player count does not match dimension");
            }
            return true;
        }

        public Game build() throws InvalidDimensionException, InvalidPlayerCountException {
            isValid();

            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setMoves(new ArrayList<>());
            game.setPlayers(players);
            game.setNextPlayerIndex(0);
            game.setGameStatus(GameStatus.INPROGRESS);
            game.setWinDetectionStratergy(new ByRowColDiaWinDetectionStratergy(dimension));
            return game;
        }
    }
}
