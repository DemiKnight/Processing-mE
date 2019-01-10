package com.krypticalKnight.processingMe.world;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.Stage;
import com.krypticalKnight.processingMe.world.worldobjects.Wall;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;


public class Level extends Stage {

    public Level()
    {

    }

    protected Level(String id) {
        super(id);
    }

    public Level createLevel(JSONObject rawLevel, int levelIndex)
    {
        String levelTag = levelIndex + ":" + rawLevel.getJSONObject("meta").getString("id");
        Level newLevel = new Level(levelTag);
        LinkedList<Entity> tempEntityToLoadList = new LinkedList<>();

        /* ################ Meta Data #####################*/
        /* ################ Structure Data #####################*/



        JSONObject structure = rawLevel.getJSONObject("structure");

//        System.out.println(structure.toString());

        Iterator structureIt = structure.keyIterator();
        while (structureIt.hasNext())
        {
            String instructionKey = (String) structureIt.next();


            switch (instructionKey)
            {
                case "create-wall":

                    for (int index = 0; index < structure.getJSONArray(WorldHandler.WorldCommands.CommandBuildWall.getCommandRaw()).size() - 1; index++)
                    {
                        System.out.println(structure.toString());

                        JSONArray WallParamaters = structure.getJSONArray(WorldHandler.WorldCommands.CommandBuildWall.getCommandRaw()).getJSONArray(index);

                        Application.getEntityManager().RegisterEntity(
                                Wall.createWall(WallParamaters,levelTag + ":" + index));


                    }

                    break;
            }

        }


        /* ################ Background Data #####################*/


        entitiesToLoad = tempEntityToLoadList.toArray(new Entity[0]);
        return newLevel;
    }

    /**
     *
     * @param listOfWalls List of walls to add.
     */
    private void handleCreateWall(JSONArray listOfWalls)
    {

        for(int wallIndex = 0; wallIndex < listOfWalls.size(); wallIndex++)
        {

        }
    }

}