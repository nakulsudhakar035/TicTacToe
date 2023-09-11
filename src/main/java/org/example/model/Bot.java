package org.example.model;

import org.example.factory.BotPlayingStratergyFactory;
import org.example.stratergy.botplayingstratergy.BotPlayingStratergy;

public class Bot extends Player {

    BotDifficultyLevel botDifficultyLevel;

    BotPlayingStratergy botPlayingStratergy;

    public Bot(char symbol, String name, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(symbol, name, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        if(botDifficultyLevel == BotDifficultyLevel.EASY){
            this.botPlayingStratergy = BotPlayingStratergyFactory.getBotPlayingStratergy(botDifficultyLevel);
        }
    }

    public Move makeNextMove(Board board) {
        return botPlayingStratergy.makeMove(board,this);
    }
}
