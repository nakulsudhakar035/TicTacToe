package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int dimension;
    List<List<Cell>> cells;

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public Board(int dimension){
        cells = new ArrayList<>();
        this.dimension = dimension;
        for(int i = 0; i < dimension; i++){
            cells.add(new ArrayList<>());
            for(int j = 0; j < dimension; j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void displayBoard(){
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                Cell cell = this.cells.get(i).get(j);
                if(cell.cellState == CellState.AVAILABLE){
                    System.out.print("|  |");
                } else if (cell.cellState == CellState.MARKED){
                    System.out.print("| "+ cell.player.symbol +" |");
                }
            }
            System.out.println();
        }
    }
}
