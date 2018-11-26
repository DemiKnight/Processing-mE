package com.krypticalKnight.processingMe;

import com.krypticalKnight.processingMe.entities.EntityManager;
import com.krypticalKnight.processingMe.render.RenderManager;
import com.krypticalKnight.processingMe.render.ResourceManager;
import com.krypticalKnight.processingMe.util.Logger;
import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

public class MainApp extends PApplet{

    private static String version = "0.0.5";

    private static ResourceManager resourceM = new ResourceManager();
    protected static EntityManager entityM /*= new EntityManager(renderM,resourceM)*/;
    private static RenderManager renderM;

    private static PApplet instance;

    public static Logger mainLogger = new Logger("Processing-Me");


    public static void main(String[] args)
    {
        mainLogger.LogInformation("Processing-Me Started! Made By Alex Knight");
        PApplet.main("com.krypticalKnight.processingMe.MainApp");

    }

    public void preInit()
    {
        mainLogger.LogInformation("Pre Init :: Start");
        //Allows processing functions to be called throughout the application
        instance = this;

        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
        mainLogger.LogInformation("Pre Init :: End");
    }

    public void init()
    {
        mainLogger.LogInformation("Init :: Start");

        entityM.giveParentInstance(this);

        renderM.init();
        mainLogger.LogInformation("Init :: End");

    }

    public void postInit()
    {
        mainLogger.LogInformation("Post Init :: Start");


        mainLogger.LogInformation("Pre Init :: End");
    }

    public void settings()
    {
        size(250,250);
        preInit();
    }

    public void setup()
    {
        fill(120);
        init();
    }

    public void draw()
    {
        entityM.updateEntities();

        renderM.clear(this);
        renderM.renderFrame();
    }

    @Contract(pure = true)
    public static EntityManager getEntityM() {
        return entityM;
    }

    @Contract(pure = true)
    public static PApplet getInstance()
    {
        return instance;
    }
}
