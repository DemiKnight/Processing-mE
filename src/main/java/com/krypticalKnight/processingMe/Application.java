package com.krypticalKnight.processingMe;

import com.krypticalKnight.processingMe.entities.EntityManager;
import com.krypticalKnight.processingMe.entities.StageManager;
import com.krypticalKnight.processingMe.render.RenderManager;
import processing.core.PApplet;

import static com.krypticalKnight.processingMe.MainApp.mainLogger;

public class Application extends PApplet {

//    private static ResourceManager resourceM = new ResourceManager();


    protected static EntityManager entityM = new EntityManager();
    protected static RenderManager renderM = new RenderManager();
    protected static StageManager stageM = new StageManager();

    protected static String defaultStageID = "MainMenu";

    public void run()
    {
        preInit();

        init();

        postInit();
    }

    /**
     * This method will:
     * - Register All Entities, things that can be viewed on screen
     * - Register All Stages, entities that hold what is being viewed.
     * - Gather the resource locations of each resource.
     */
    protected void preInit()
    {
        mainLogger.LogInformation("Pre Init :: Start");
        //Allows processing functions to be called throughout the application

        renderM.getResourceM().gatherResources(entityM);

        //Setup the sketch path. Used when gathering relative resources, such as images and shapes.
        //Required for the PApplet.loadImage() method.
        this.sketchPath();

        mainLogger.LogInformation("Pre Init :: End");
    }

    /**
     * This method will:
     * - Fetch and load resources.
     */
    protected void init()
    {
        mainLogger.LogInformation("Init :: Start");


        renderM.getResourceM().loadResources(this);

//        entityM.giveParentInstance(this);
//        renderM.init();

        mainLogger.LogInformation("Init :: End");
    }

    /**
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


}
