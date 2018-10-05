package com.krypticalKnight.processingGame;

import java.io.File;

public class ConfigManager {

    private static File configFile;
    /**
     * Reads the config and stores the default for use throughout the program.
     *
     *
     * @return whether the operation was successful or not.
     */
    public static byte init()
    {
        configFile = new File("config.json");

        System.out.println(configFile.exists());

        return 1;
    }

}
