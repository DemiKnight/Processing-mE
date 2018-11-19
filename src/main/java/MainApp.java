import processing.core.PApplet;
import render.RenderManager;
import render.ResourceManager;

public class MainApp extends PApplet{

    private static String version = "0.0.3";

//    private ConfigManager configM = new ConfigManager();

    private static RenderManager renderM;
    private static EntityManager entityM;
    private static ResourceManager resourceM;


    public static void main(String[] args)
    {
        resourceM = new ResourceManager();

        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
        
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
