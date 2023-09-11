package org.example.stratergy.botplayingstratergy;

import org.example.model.*;

public class EasyBotPlayingStratergy implements BotPlayingStratergy {

    @Override
    public Move makeMove(Board board, Player player) {
        int dimension = board.getDimension();
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                if(board.getCells().get(i).get(j).getCellState()== CellState.AVAILABLE){
                    return new Move(player, new Cell(i,j,CellState.MARKED, player));
                }
            }
        }
        return null;
    }
}
