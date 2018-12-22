package com.krypticalKnight.processingMe;

import com.krypticalKnight.processingMe.entities.EntityManager;
import com.krypticalKnight.processingMe.render.RenderManager;
import com.krypticalKnight.processingMe.render.ResourceManager;
import com.krypticalKnight.processingMe.util.Logger;
import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

public class MainApp
{
    private static String version = "0.0.5";

//    private static ResourceManager resourceM = new ResourceManager();
//    protected static EntityManager entityM /*= new EntityManager(renderM,resourceM)*/;
//    private static RenderManager renderM;

//    private static PApplet instance;

    public static Logger mainLogger = new Logger("Processing-Me");

    private static Application app = new Application();


    public static void main(String[] args)
    {
        mainLogger.LogInformation("Processing-Me Started! Made By Alex Knight");

        app.run();

        PApplet.main("com.krypticalKnight.processingMe.MainApp");
    }

}
