package com.krypticalKnight.processingMe.util;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.GameState;
import com.krypticalKnight.processingMe.entities.Stage;

public class MainMenu extends Stage
{
    public MainMenu()
    {
        super("MainMenu");
    }

    private void playGame()
    {
        Application.switchState(GameState.World);
    }

}
