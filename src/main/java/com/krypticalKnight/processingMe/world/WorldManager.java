package com.krypticalKnight.processingMe.world;

import com.krypticalKnight.testApp.TestApp;
import org.jetbrains.annotations.NotNull;
import processing.data.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.stream.Stream;

@SuppressWarnings("JavadocReference")
public class WorldManager
{

    /**
     * @brief Contains all {@link World}s that be used within the
     * @note Will be set during {@link com.krypticalKnight.processingMe.Application.preInit() preInit()}.
     */
    private World[] worldList;

    private static LinkedList<Path> rawWorldPaths = new LinkedList<>();

    /**
     * @brief Add a JSON file to turned into a {@link World}.
     * @warning After JSON files have initially been processed, in the {@link com.krypticalKnight.processingMe.Application.preInit() preInit()}, will be Null
     * @param[in] newPath Add a new JSON World file to be used.
     */
    private static void addWorldPath(@NotNull Path newPath)
    {
        rawWorldPaths.add(newPath);
    }

    /**
     * @brief The {@link World} currently loaded.
     * @note Reference to element within {@link WorldManager.worldList}
     */
    private World currentWorld;

    /**
     * @brief Check if a select file is an applicable/syntactically correct Json World File.
     *
     * @todo Impletement this during {@link WorldManager.loadWorlds() loadWorlds()}.
     * @param[in] filePath Json World file to check.
     * @return Whether the select file is a syntactically correct World.
     */
    private static boolean isWorld( @NotNull Path filePath)
    {
        try
        {
            return filePath.endsWith(".json");
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @brief Load worlds from .json files to World object, and being able to render them.
     * @details
     * Load all JSON world files, convert to {@link World} objects. After this function, Worlds will be accessible to the
     * rest of the application.
     * @note Before calling this function, all required JSON Files should be appended to {@link WorldManager.rawWorldPaths rawWorldPaths} using {@link WorldManager.addWorldPath() addWorldPath()}.
     */
    public void init()
    {
        //Gather worlds to load.
        loadWorlds();

        //Convert raw json to World object
        convertWorlds();

        rawWorldPaths = null; //No longer needed. Might be removed if a save feature is added.
    }

    /**
     * @brief Obtain raw JSON from any worlds within the resources/world folder,
     *
     */
    private void loadWorlds()
    {

        // The try-with-resources Statement, Accessed 24/12/2018 <https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html>

        //Declare Path that would represent the world folder.
        Path worldFolder = null;

        //Attempt to gain access to the folder.
        try {
            worldFolder = Paths.get(ClassLoader.getSystemClassLoader().getResource("com.krypticalKnight.testApp/world").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        //If the world folder was found successfully...
        if (worldFolder != null)
        {
            //Attempt to 'walk' through the directory and add the corresponding world to the paths to load.
            // TODO Add filter to eliminate all non world.json files.
            try(Stream<Path> filePaths = Files.walk(worldFolder))
            {

                filePaths.filter(Files::isRegularFile).forEach(WorldManager::addWorldPath);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }else
        {
            TestApp.testAppLogger.LogError("Unable to load any worlds!");
        }

    }

    /**
     * Load and convert json worlds to {@link World}
     */
    private void convertWorlds()
    {
        String rawWorldJson;
        byte[] rawWorldData;

        LinkedList<World> tempWorldList = new LinkedList<>();

        for (Path worldPath: rawWorldPaths)
        {
            //Clear variable from previous attempts.
            rawWorldJson = "";


            try
            {
                //Get all informaiton within the
                //Load raw data
                rawWorldData = Files.readAllBytes(worldPath);
            }
            catch (IOException e)
            {
                rawWorldData = null;
                e.printStackTrace();
            }



            //If the file contains some data to load.
            if (rawWorldJson.isEmpty() && rawWorldData != null)
            {
                //Convert data into a string.
                rawWorldJson = new String(rawWorldData, Charset.defaultCharset());

                //Convert world json file to JsonObject
                JSONObject JSONData = JSONObject.parse(rawWorldJson);


//                System.out.println(JSONData.getJSONObject("worldData").getString("name"));
//                World newWorld = World.createWorld(JSONData);
                tempWorldList.add(World.createWorld(JSONData));
            }

        }
        this.worldList = tempWorldList.toArray(new World[0]);
    }
}
