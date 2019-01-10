package com.krypticalKnight.processingMe.world;

import processing.data.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class World {

    private int WIDTH_WORLD;
    private int HEIGHT_WORLD;

    private String ID;

    private Level[] levels;

    public void loadWorld(JSONObject rawWorldData)
    {

    }

    public int getHeight()
    {
        return this.HEIGHT_WORLD;
    }

    public int getWidth()
    {
        return this.WIDTH_WORLD;
    }

   public static World createWorld(JSONObject rawWorldData)
   {
//       System.out.println(WorldHandler.WorldCommands.FormatVersion.getCommandRaw());

       JSONObject rawLevelData = rawWorldData.getJSONObject("level");
       JSONObject rawMetaData = rawWorldData.getJSONObject("worldData");
       World newWorld = null;

       try
       {
           LinkedList<Level> tempLevelStore = new LinkedList<>();

           newWorld = new World();
           newWorld.ID = rawMetaData.getString("name"); //Name is required.
           newWorld.WIDTH_WORLD = rawMetaData.getInt("width", 200);
           newWorld.HEIGHT_WORLD = rawMetaData.getInt("height", 200);

           Iterator levelIterator = rawLevelData.keyIterator();

           while (levelIterator.hasNext())
           {
              String levelIndex = (String) levelIterator.next();


              tempLevelStore.add( new Level().createLevel(rawLevelData.getJSONObject(levelIndex), Integer.parseInt(levelIndex)));

//              System.out.println(.toString());

           }

       }
       catch (NullPointerException e)
       {
           e.printStackTrace();
       }

       return newWorld;
   }

}
