package com.krypticalKnight.processingMe.world;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.StageManager;
import processing.data.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class World {

    private int WIDTH_WORLD;
    private int HEIGHT_WORLD;

    private String ID;

    private Level[] levels;



    public int getHeight()
    {
        return this.HEIGHT_WORLD;
    }

    public int getWidth()
    {
        return this.WIDTH_WORLD;
    }

    /**
     * Convert a World.json to a World object.
     *
     * @param rawWorldData The full Data from a world.json
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

            Application.getStageManager(). = newWorld.levels[rawMetaData.getInt("default-level")];

        }
        catch (NullPointerException e)
        {
           e.printStackTrace();
        }

        return newWorld;
    }


}
