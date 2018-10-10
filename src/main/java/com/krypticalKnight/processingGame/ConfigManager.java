package com.krypticalKnight.processingGame;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ConfigManager {

    private static File configFile;
    private static ArrayList[][] config;

    /**
     * Reads the config and stores the default for use throughout the program.
     *
     * @return whether the operation was successful or not.
     */
    public static byte init() {
        Properties pathProperties = new Properties();
//        String temp = this.getClass().getResource("cofig.json").toString();

        InputStream paths = pathProperties.getClass().getResourceAsStream("/config.json");
//        System.out.println(instance.getResource("config.json"));



        return 0;
    }

    private static void loadConfigIntoLists() {
        List<String> fileLines = Collections.emptyList();

        try {
            fileLines = Files.readAllLines(Paths.get(configFile.getPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        populateConfigfromList(fileLines);
    }

    private static void populateConfigfromList(List<String> inputList)
    {
        for(short index = 0; index <= inputList.size() ;index++)
        {
            //Test
            System.out.println("ELement: " +index + ", "+ inputList.get(index));
        }
    }


}
