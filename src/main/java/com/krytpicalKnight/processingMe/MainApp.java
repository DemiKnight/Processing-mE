package com.krytpicalKnight.processingMe;

import com.krytpicalKnight.processingMe.render.RenderManager;
import com.krytpicalKnight.processingMe.render.ResourceManager;
import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

public class MainApp extends PApplet{

    private static String version = "0.0.5";

    private static ResourceManager resourceM = new ResourceManager();
    protected static EntityManager entityM /*= new EntityManager(renderM,resourceM)*/;
    private static RenderManager renderM;
    private static PApplet instance;

    public static void main(String[] args)
    {
        PApplet.main("MainApp");
    }

    public void preInit()
    {
        //Allows processing functions to be called throughout the application
        instance = this;

        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
    }

    public void init()
    {
        renderM.init();
        entityM.giveParentInstance(this);

    }

    public void postInit()
    {
        //WIP
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
