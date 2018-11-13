import processing.core.PApplet;
import render.RenderManager;

public class MainApp extends PApplet{

    private static String version = "0.0.1";

//    private ConfigManager configM = new ConfigManager();

    private static RenderManager renderM;

    public static void main(String[] args)
    {
        renderM = new RenderManager();

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
