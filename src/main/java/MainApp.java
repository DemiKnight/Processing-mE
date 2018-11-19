import processing.core.PApplet;
import render.RenderManager;
import render.ResourceManager;
import render.ResourceRequirements;
import test.TestEntity;

public class MainApp extends PApplet{

    private static String version = "0.0.4";

//    private ConfigManager configM = new ConfigManager();

    private static RenderManager renderM;
    private static EntityManager entityM;
    private static ResourceManager resourceM;
    private static PApplet instance;


    public static void main(String[] args)
    {
        resourceM = new ResourceManager(instance);
        renderM = new RenderManager(resourceM);
        entityM = new EntityManager(renderM,resourceM);
        PApplet.main("MainApp");
    }

    private void preInit()
    {
        instance = this;

        TestEntity test1 = new TestEntity(this);

        entityM.addToRegistry(test1,true);

    }

    private void init()
    {
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
