/**
 * @mainpage Processing mE - Game Engine documentation
 *
 * @section introduction_section Introduction
 *
 * This program was written to allow the <a href="https://processing.org/" target="_blank">Processing Library</a> to perform
 * more like a game engine.
 *
 * @section uml_Section UML
 *
 * UML of Processing Me.
 * @image html Processing-Me-Complete.png
 *
 * @section howToUse_section How To Use
 *
 * The main object is {@link com.krypticalKnight.processingMe.Application Application} which contains all methods for
 * setting up and rendering the game.
 *
 *
 * @section manchesterMet_section Manchester Metropolitan University Assignment
 *
 * <ul>
 *     <li>Assignment Name: Mouse click game <b>1CWK40</b></li>
 *     <li>Created By: Alex Knight <b>18016816</b></li>
 * </ul>
 */

package com.krypticalKnight.processingMe;

import com.krypticalKnight.processingMe.entities.EntityManager;
import com.krypticalKnight.processingMe.entities.StageManager;
import com.krypticalKnight.processingMe.render.RenderManager;
import com.krypticalKnight.processingMe.world.WorldManager;
import processing.core.PApplet;

import static com.krypticalKnight.processingMe.MainApp.mainLogger;

/**
 * @brief Main class running the entire application, front and backend.
 *
 * This application will gather resources used for
 *
 * @class Application
 *
 * @author Alex Knight (DemiKnight)
 * @since 0.1.0
 */
public class Application extends PApplet {

    /**
     * Contains all entities being
     *
     */
    protected static EntityManager entityM = new EntityManager();

    /**
     *
     */
    protected static RenderManager renderM = new RenderManager();

    /**
     * @brief  A list of possible {@link com.krypticalKnight.processingMe.entities.Stage Stage}
     *
     * @see com.krypticalKnight.processingMe.entities.Stage
     */
    protected static StageManager stageM = new StageManager();

    /**
     * Co
     */
    protected static WorldManager worldM = new WorldManager();

    /**
     * @brief The first stage to be loaded by the Stage Manager.
     *
     * @details
     * Using a stage with the ID "MainMenu", load the stage after
     *
     * @see com.krypticalKnight.processingMe.entities.StageManager
     */
    protected static String defaultStageID = "MainMenu";


    /**
     * @brief Gather and setup resources necessary for the application to function.
     *
     * @details
     * The application will execute @ref preInit(), @ref init(), @ref postInit() sequentially. By the end,
     * the program should be able to be successfully render/function.
     *
     * @see preInit()
     * @see init()
     * @See postInit()
     */
    public void setupApplication()
    {
        preInit();

        init();

        postInit();
    }

    /**
     * @brief Load files and setup critical objects.
     *
     * @details
     *
     *
     * This method will:
     * - Register All Entities, things that can be viewed on screen
     * - Register All Stages, entities that hold what is being viewed.
     * - Gather the resource locations of each resource.
     *
     * @link     StageManager
     */
    protected void preInit()
    {
        mainLogger.LogInformation("Pre Init :: Start");
        //Allows processing functions to be called throughout the application

        renderM.getResourceM().gatherResources(entityM);

        //Setup the sketch path. Used when gathering relative resources, such as images and shapes.
        //Required for the PApplet.loadImage() method.
        this.sketchPath();

        worldM.init();

        mainLogger.LogInformation("Pre Init :: End");
    }

    /**
     * @brief Initialise and finish loading critical objects.
     *
     * @details
     * This method will:
     * - Fetch and load resources.
     */
    protected void init()
    {
        mainLogger.LogInformation("Init :: Start");


        entityM.FinaliseRegistry();

        renderM.getResourceM().loadResources(this);

//        entityM.giveParentInstance(this);
//        renderM.init();

        mainLogger.LogInformation("Init :: End");
    }

    /**
     * @brief Setup variables and environment for the program to run in.
     *
     * @details
     * This method will:
     * - Load first stage.
     */
    protected void postInit()
    {
        mainLogger.LogInformation("Post Init :: Start");

        //Will always try and load the MainMenu
        stageM.loadStage(defaultStageID);

        mainLogger.LogInformation("Pre Init :: End");
    }

    public void draw()
    {
        clear();
        background(170);
        renderM.draw(stageM, this);
        entityM.runUpdate(stageM);
    }

    @Override
    public void settings() {
        size(500,500);
    }

    public static EntityManager getEntityManager()
    {
        return entityM;
    }
    public static RenderManager getRenderManager() { return renderM; }
    public static StageManager getStageManager() { return stageM; }

}
