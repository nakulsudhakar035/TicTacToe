package org.example.stratergy.windetectionstratergy;

import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ByRowColDiaWinDetectionStratergy implements WinDetectionStratergy {

    List<HashMap<Character, Integer>> rowMaps = new ArrayList<>();
    List<HashMap<Character, Integer>> colMaps = new ArrayList<>();

    HashMap<Character, Integer> topLeftDia;

    HashMap<Character, Integer> topRightDia;
    public ByRowColDiaWinDetectionStratergy(int dimension){
        for(int i = 0; i < dimension; i++){
            rowMaps.add(new HashMap<>());
            colMaps.add(new HashMap<>());
        }
        topLeftDia = new HashMap<>();
        topRightDia = new HashMap<>();
    }

    @Override
    public boolean checkIfMatchPoint(Board board, Player player, Cell cell) {
        int rowNo = cell.getRowNo();
        int colNo = cell.getColNo();
        char symbol = player.getSymbol();
        int dimension = board.getDimension();

        if(!rowMaps.get(rowNo).containsKey(player.getSymbol())){
            rowMaps.get(rowNo).put(symbol, 0);
        }
        rowMaps.get(rowNo).put(symbol, rowMaps.get(rowNo).get(symbol)+1);

        if(!colMaps.get(colNo).containsKey(player.getSymbol())){
            colMaps.get(colNo).put(symbol, 0);
        }
        colMaps.get(colNo).put(symbol, colMaps.get(colNo).get(symbol)+1);

        if(cell.isOnTopLeftDia()){
            if(!topLeftDia.containsKey(symbol)){
                topLeftDia.put(symbol,0);
            }
            topLeftDia.put(symbol,topLeftDia.get(symbol)+1);
        }

        if(cell.isOnTopRightDia(dimension)){
            if(!topRightDia.containsKey(symbol)){
                topRightDia.put(symbol,0);
            }
            topRightDia.put(symbol,topRightDia.get(symbol)+1);
        }


        if(rowMaps.get(rowNo).containsKey(symbol) && rowMaps.get(rowNo).get(symbol)==dimension){
            return true;
        }
        if(colMaps.get(colNo).containsKey(symbol) && colMaps.get(colNo).get(symbol)==dimension){
            return true;
        }

        if((topRightDia.containsKey(symbol) && topRightDia.get(symbol)==dimension)
                || (topLeftDia.containsKey(symbol) && topLeftDia.get(symbol)==dimension)){
            return true;
        }

        return false;
    }
}
