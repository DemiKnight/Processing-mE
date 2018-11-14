import processing.core.PApplet;
import render.RenderManager;

public class MainApp extends PApplet{

    private static String version = "0.0.3";

//    private ConfigManager configM = new ConfigManager();

    private static RenderManager renderM;
    private static EntityManager entityM;


    public static void main(String[] args)
    {
        renderM = new RenderManager();
        entityM = new EntityManager(renderM);

        PApplet.main("MainApp");
    }

    public void settings()
    {
        size(250,250);
    }

    public void setup()
    {
        fill(120);
    }

    public void draw()
    {
        renderM.clear(this);

        renderM.renderFrame();
    }

}
