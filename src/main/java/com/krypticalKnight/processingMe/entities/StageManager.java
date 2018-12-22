package com.krypticalKnight.processingMe.entities;


import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.util.UseableResource;

import java.util.LinkedList;

public class StageManager {

    private Stage[] stageList;

    private UseableResource<Stage>[] stageDictionary;

    private Stage currentStage;

    public void loadStage(int stageIndexLocation)
    {
        currentStage = stageList[stageIndexLocation];
    }

    public void loadStage(String stageID)
    {
        boolean stageFound = false;
        for (int index = 0;!stageFound && index < stageDictionary.length; index++)
        {
            if(stageDictionary[index].getID().equals(stageID))
            {
                stageFound=true; //No need to continue searching.
                currentStage = stageDictionary[index].getResoure();
            }
        }
        if(!stageFound)
        {
            MainApp.mainLogger.LogError("Unable to load stage! With stageID: " + stageID);
        }
    }

    private void updateRenderList()
    {

    }

    private void updateUpdateList()
    {

    }

    public void Registry(StageRegistry newStageRegistry)
    {
        LinkedList<Stage> tempStageCache = new LinkedList<>();

        newStageRegistry.RegisterStages(tempStageCache);

        stageDictionary = new UseableResource[tempStageCache.size()];

        for (int index = 0; index < stageDictionary.length; index++) {
            stageDictionary[index] = new UseableResource<Stage>(tempStageCache.get(index),tempStageCache.get(index).getID());
        }

        this.stageList = tempStageCache.toArray(new Stage[0]);
    }

}
