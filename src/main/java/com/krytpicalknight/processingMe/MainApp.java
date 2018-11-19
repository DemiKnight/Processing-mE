package com.krytpicalknight.processingMe;

import processing.core.PApplet;
import com.krytpicalknight.processingMe.render.RenderManager;
import com.krytpicalknight.processingMe.render.ResourceManager;
import com.krytpicalknight.processingMe.test.TestEntity;

public class MainApp extends PApplet{

    private static String version = "0.0.4";

//    private com.krytpicalknight.processingMe.ConfigManager configM = new com.krytpicalknight.processingMe.ConfigManager();

    private static RenderManager renderM;
    private static EntityManager entityM;
    private static ResourceManager resourceM;
    private static PApplet instance;


    public static void main(String[] args)
    {
        resourceM = new ResourceManager(instance);
        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
        PApplet.main("com.krytpicalknight.processingMe.MainApp");
    }

    private void preInit()
    {
//        System.out.println("Pre-init started");
        instance = this;

        TestEntity test1 = new TestEntity(this);

        entityM.addToRegistry(test1,true);

//        System.out.println("Pre-Init ended");
    }

    private void init()
    {
//        System.out.println("Init Started");
        entityM.registerResource();


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
