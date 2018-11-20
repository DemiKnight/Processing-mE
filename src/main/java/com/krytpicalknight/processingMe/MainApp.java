package com.krytpicalknight.processingMe;

import processing.core.PApplet;
import com.krytpicalknight.processingMe.render.RenderManager;
import com.krytpicalknight.processingMe.render.ResourceManager;
import com.krypticalKnight.testApp.entities.TestEntity;

public class MainApp extends PApplet{

    private static String version = "0.0.4";

//    private com.krytpicalknight.processingMe.ConfigManager configM = new com.krytpicalknight.processingMe.ConfigManager();

    protected static RenderManager renderM;
    protected static EntityManager entityM;
    protected static ResourceManager resourceM;
    private PApplet instance;


    public static void main(String[] args)
    {
        PApplet.main("com.krytpicalknight.processingMe.MainApp");
    }

    public void preInit()
    {
        resourceM = new ResourceManager();
        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
    }

    public void init()
    {
//        System.out.println("Init Started");
        entityM.registerResource();
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
        renderM.clear(this);
        renderM.renderFrame();
    }

}
