package com.krypticalKnight.processingMe.world;

import processing.data.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @brief Contains information about the virtual game world.
 * @details
 * A World is a virtual space which will contain various {@link Level Levels}, which in turn will contain {@link com.krypticalKnight.processingMe.entities.Entity Entities}.
 * Worlds are created from JSON files, in the method {@link WorldManager.convertWorlds() convertWorlds} during {@link WorldManager.init() init()}.
 * The world size, {@link World.WIDTH_WORLD WIDTH_WORLD} & {@link World.HEIGHT_WORLD HEIGHT_WORLD} is not represented by pixels. Instead being relative to the viewport.
 *
 * @todo Make World Height relative to the viewport.
 * @author Alex Knight (DemiKnight)
 * @since 0.1.1
 */
@SuppressWarnings("JavadocReference")
public class World {

    /**
     * The world size
     * @todo Does not currently
     */
    private int WIDTH_WORLD;
    private int HEIGHT_WORLD;

    /**
     * @brief A unique ID representing the {@link World}.
     */
    private String ID;

    public String getID() {
        return ID;
    }

    /**
     * @brief Contains {@link Level levels} defined in the JSON
     * @see Level
     */
    private Level[] levels;

    /**
     *
     * @return The Height of the World
     */
    public int getHeight()
    {
        return this.HEIGHT_WORLD;
    }

    /**
     *
     * @return
     */
    public int getWidth()
    {
        return this.WIDTH_WORLD;
    }

    /**
     * @brief Convert a World.json to a {@link World} object.
     *
     * @details
     * Phases through the entire JSON object, looking for <b>"worldData"</b> and <b>"levels"</b> objects.
     * <b>"worldDate"</b> contains information that will be applied to this object. <b>levels</b> object will contain
     * an array of objects that will then use {@link Level.createLevel() createLevel()} to create a new instance of
     * {@link Level} and add it to {@link World.levels levels}.
     *
     *
     * @param[in] rawWorldData The full Data from a world.json
     * @return New World object.
     */
    public static World createWorld(JSONObject rawWorldData)
    {
        //Contains all the JSON data for building each level.
        JSONObject rawLevelData = rawWorldData.getJSONObject("level");

        //Contains all meta information for the entire world.
        JSONObject rawMetaData = rawWorldData.getJSONObject("worldData");

        World newWorld = null;

        try
        {
            //Temp store for all levels.
            LinkedList<Level> tempLevelStore = new LinkedList<>();

            newWorld = new World();

            // World meta data.
            newWorld.ID = rawMetaData.getString("name"); //Name is required.
            newWorld.WIDTH_WORLD = rawMetaData.getInt("width", 200);
            newWorld.HEIGHT_WORLD = rawMetaData.getInt("height", 200);

            Iterator levelIterator = rawLevelData.keyIterator();

            //Iterate all "level" children.
            while (levelIterator.hasNext())
            {
                String levelIndex = (String) levelIterator.next();

//                System.out.println(levelIndex);

                tempLevelStore.add( new Level().createLevel(rawLevelData.getJSONObject(levelIndex), Integer.parseInt(levelIndex)));

            //              System.out.println(.toString());

            }


            newWorld.levels = tempLevelStore.toArray(new Level[0]);

//            Application.getStageManager(). = newWorld.levels[rawMetaData.getInt("default-level")];

        }
        catch (NullPointerException e)
        {
           e.printStackTrace();
        }

        return newWorld;
    }
}
