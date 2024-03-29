package uk.co.alexknight.processingme;

import processing.core.PApplet;
import uk.co.alexknight.processingme.util.Logger;

public class MainApp
{
    private static String version = "0.1.0";

//    private static ResourceManager resourceM = new ResourceManager();
//    protected static EntityManager entityM /*= new EntityManager(renderM,resourceM)*/;
//    private static RenderManager renderM;

//    private static PApplet instance;

    public static Logger mainLogger = new Logger("Processing-Me");

    private static Application app = new Application();


    public static void main(String[] args)
    {
        mainLogger.LogInformation("Processing-Me Started! Made By Alex Knight");

        app.setupApplication();

        PApplet.main("com.krypticalKnight.processingMe.Application");
    }

}
