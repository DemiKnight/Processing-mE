import util.JsonReader;

public class ConfigManager {

    /**
     * Reads the config and stores the default for use throughout the program.
     *
     * @return whether the operation was successful or not.
     */
    public static byte init() {

        JsonReader configFile = new JsonReader("../config.json");


        return 0;
    }

}
