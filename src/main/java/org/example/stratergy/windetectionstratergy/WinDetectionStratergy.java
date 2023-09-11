package org.example.stratergy.windetectionstratergy;

import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Player;

public interface WinDetectionStratergy {

    public boolean checkIfMatchPoint(Board board, Player player, Cell cell);

}
