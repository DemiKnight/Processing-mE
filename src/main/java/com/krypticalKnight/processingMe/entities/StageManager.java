/**
 * @page StageTutorial Using Stages in Processing-Me
 * @tableofcontents
 * {@link com.krypticalKnight.processingMe.entities.Stage Stages} are the most basic way of organising what is being rendered
 * to the screen. Each stage is a {@link com.krypticalKnight.processingMe.world.Level Level} created in the {@link com.krypticalKnight.processingMe.util.WorldPhraser World Phaser}.
 *
 * @section creatingStages Getting Started
 * @subsection creatingStages Creating a Registry.
 * Firstly, create
 * @section defaultStage Default Stage/Main Menu
 * The {@link com.krypticalKnight.processingMe.entities.Stage Stage} with the ID "MainMenu" needs to exist
 */
package com.krypticalKnight.processingMe.entities;


import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.util.UseableResource;
import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

import java.util.LinkedList;

/**
 * @brief Stores all stages with entity states within them.
 *
 * @details
 *
 * Will aid in loading and storing {@link Stage}. Only one stage can be loaded at one time,
 * and unloading a table, will need all previously created entities to be destroyed.
 *
 * @class StageManager
 * @author Alex Knight (DemiKnight)
 * @since 0.1.0
 *
 * @see Stage
 */
@SuppressWarnings("JavadocReference")
public class StageManager {

    /**
     * @brief Stores possible stages.
     * @details
     *
     * All possible stages, when active will be referenced by {@link StageManager.currentStage currentStage}.
     *
     */
    private Stage[] stageList;

    private LinkedList<Stage> tempStageList = new LinkedList<>();

    private UseableResource<Stage>[] stageDictionary;

    /**
     * @breif The {@link Stage} currently loaded.
     */
    private Stage currentStage;


    public void loadStage(int stageIndexLocation)
    {
        currentStage = stageList[stageIndexLocation];
        currentStage.init();
    }

    /**
     * @brief Load a given stage, overriding the current one if successful.
     *
     * @details
     *
     * Load the {@link Stage}, including initialising all required entities and the default properties.
     * Executing this will cause the current {@link Stage} to unload.
     *
     * @todo ALlow loading to take into consideration previous information stored either temporarily or on the disk.
     *
     * @note Must be present in {@link StageManager.Registry Registry}
     * @param[in] stageID The ID given to each stage.
     */
    public void loadStage(String stageID)
    {
        boolean stageFound = false;

        for (int stageIndex = 0; stageIndex < stageList.length && !stageFound; stageIndex++)
        {
            if (stageList[stageIndex].getID() == stageID)
            {
                stageFound=true;
                currentStage = stageList[stageIndex];
                currentStage.init();
            }
        }
//
//        for (int index = 0; !stageFound && index < stageDictionary.length; index++)
//        {
//            if(stageDictionary[index].getID().equals(stageID))
//            {
//                stageFound = true; //No need to continue searching.
//                currentStage = stageDictionary[index].getResoure();
//                currentStage.init();
//            }
//        }
        if(!stageFound)
        {
            MainApp.mainLogger.LogError("Unable to load stage! With stageID: " + stageID);
        }

    }

    /**
     * @brief Setup predetermined stages for use within the application.
     *
     * @details
     *
     * Will load all stages registered within the {@link StageRegistry}, to be used throughout the application.
     *
     * @note Can only be called once.
     * @note Must be called within {@link Application.preInit() preInit()}
     *
     * @param[in] newStageRegistry File containing all stages to register.
     */
    public void Registry(StageRegistry newStageRegistry)
    {
//        LinkedList<Stage> tempStageCache = new LinkedList<>();

        newStageRegistry.RegisterStages(tempStageList);

//        stageDictionary = new UseableResource[tempStageList.size()];
//
//        for (int index = 0; index < stageDictionary.length; index++) {
//            stageDictionary[index] = new UseableResource<Stage>(tempStageCache.get(index), tempStageCache.get(index).getID());
//        }

//        this.stageList = tempStageCache.toArray(new Stage[0]);
    }

    public void addStage(Stage newStage)
    {
        this.tempStageList.add(newStage);
    }

    public Stage addStageI(Stage newStage)
    {
        this.tempStageList.add(newStage);
        return tempStageList.getLast();
    }

    public void finalise()
    {
        this.stageList = tempStageList.toArray(new Stage[0]);
    }

    /**
     * @brief Get the current stage.
     *
     * @return The stage currently loaded, {@link StageManager.currentStage currentStage}.
     */
    public Stage getCurrentStage() {
        return currentStage;
    }
}
