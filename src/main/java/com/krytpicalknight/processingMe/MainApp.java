package com.krytpicalknight.processingMe;

import com.krytpicalknight.processingMe.render.RenderManager;
import com.krytpicalknight.processingMe.render.ResourceManager;
import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

public class MainApp extends PApplet{

    private static String version = "0.0.4";

    private static ResourceManager resourceM = new ResourceManager();
    protected static EntityManager entityM /*= new EntityManager(renderM,resourceM)*/;
    private static RenderManager renderM;
    private static PApplet instance;

    public static void main(String[] args)
    {
        PApplet.main("com.krytpicalknight.processingMe.MainApp");
    }

    public void preInit()
    {
//        resourceM = new ResourceManager();

        instance = this;

        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
    }

    public void init()
    {
//        System.out.println("Init Started");
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
