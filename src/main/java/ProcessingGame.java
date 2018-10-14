import processing.core.PApplet;

public class ProcessingGame extends PApplet{

    private static String version = "0.0.1";

//    private ConfigManager configM = new ConfigManager();

    public static void main(String[] args)
    {
        ConfigManager configM = new ConfigManager();

        //        if(ConfigManager.init(this)!= 0) System.err.println("Problem when loading config! Check Logs");

        PApplet.main("ProcessingGame");

    }

    public void settings()
    {
        size(720,480);
    }

    public void setup()
    {
        fill(120);
    }

    public void draw()
    {

        text("Version: " + version, width/2,height/2);
    }

}
