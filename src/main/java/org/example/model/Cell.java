package org.example.model;

public class Cell {
    int rowNo;
    int colNo;
    CellState cellState;
    Player player;

    public Cell(int rowNo, int colNo, CellState cellState, Player player) {
        this.rowNo = rowNo;
        this.colNo = colNo;
        this.cellState = cellState;
        this.player = player;
    }

    public Cell(int rowNo, int colNo){
        this.rowNo = rowNo;
        this.colNo = colNo;
        this.cellState = CellState.AVAILABLE;
    }


    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColNo() {
        return colNo;
    }

    public void setColNo(int colNo) {
        this.colNo = colNo;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isOnTopLeftDia() {
        if(this.colNo == this.rowNo){
            return true;
        }
        return false;
    }

    public boolean isOnTopRightDia(int dimension) {
        if(this.colNo + this.rowNo == (dimension-1)){
            return true;
        }
        return false;
    }
}
