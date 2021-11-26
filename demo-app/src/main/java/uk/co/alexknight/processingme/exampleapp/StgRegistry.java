package uk.co.alexknight.processingme.exampleapp;

import uk.co.alexknight.processingme.entities.Stage;
import uk.co.alexknight.processingme.entities.StageRegistry;
import uk.co.alexknight.processingme.exampleapp.stages.MainMenu;

import java.util.LinkedList;

public class StgRegistry implements StageRegistry
{
    private final MainMenu mainMenu = new MainMenu();

    @Override
    public void RegisterStages(LinkedList<Stage> listToModify)
    {
        listToModify.add(mainMenu);
    }
}
