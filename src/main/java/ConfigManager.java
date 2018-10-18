import org.jetbrains.annotations.Contract;
import util.JsonReader;

public class ConfigManager {

    private static final JsonReader configFile = new JsonReader("../config.json");;

    /**
     * Reads the config and stores the default for use throughout the program.
     *
     * @return whether the operation was successful or not.
     */
    public static void init() {

//        configFile = new JsonReader("../config.json");

    }

    public String toString()
    {
        return String.valueOf(configFile.getStoreMap().size());
    }

    @Contract(pure = true)
    public static JsonReader getConfig()
    {
        return configFile;
    }
}
