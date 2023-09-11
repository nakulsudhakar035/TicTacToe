package org.example.stratergy.botplayingstratergy;

import org.example.model.Board;
import org.example.model.Cell;
import org.example.model.Move;
import org.example.model.Player;

public interface BotPlayingStratergy {

    public Move makeMove(Board board, Player player);
}
