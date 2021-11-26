package uk.co.alexknight.processingme;

import processing.core.PApplet;
import uk.co.alexknight.processingme.entities.EntityManager;
import uk.co.alexknight.processingme.entities.StageManager;
import uk.co.alexknight.processingme.render.RenderManager;

import static uk.co.alexknight.processingme.MainApp.mainLogger;


public class Application extends PApplet {

//    private static ResourceManager resourceM = new ResourceManager();


    protected static EntityManager entityM = new EntityManager();
    protected static RenderManager renderM = new RenderManager();
    protected static StageManager stageM = new StageManager();

    protected static String defaultStageID = "MainMenu";


    public void setupApplication()
    {
        preInit();

        init();

        postInit();
//
//        String[] thisTing = new String[]{"com.krypticalKnight.processingMe.Application"};
//
//        runSketch(thisTing,this);
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
        debug("Helo");
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

}
