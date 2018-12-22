package com.krypticalKnight.testApp;

import com.krypticalKnight.processingMe.entities.Stage;
import com.krypticalKnight.processingMe.entities.StageRegistry;
import com.krypticalKnight.testApp.stages.MainMenu;

import java.util.LinkedList;

public class StgRegistry implements StageRegistry
{
    private MainMenu mainMenu = new MainMenu();

    @Override
    public void RegisterStages(LinkedList<Stage> listToModify)
    {
        listToModify.add(mainMenu);
    }
}
