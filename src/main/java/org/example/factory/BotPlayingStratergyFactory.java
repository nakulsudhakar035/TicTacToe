package org.example.factory;

import org.example.model.BotDifficultyLevel;
import org.example.stratergy.botplayingstratergy.BotPlayingStratergy;
import org.example.stratergy.botplayingstratergy.EasyBotPlayingStratergy;

public class BotPlayingStratergyFactory {

    public static BotPlayingStratergy getBotPlayingStratergy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStratergy();
        }
        return null;
    }
}
