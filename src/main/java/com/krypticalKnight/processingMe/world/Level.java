package com.krypticalKnight.processingMe.world;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.Stage;
import com.krypticalKnight.processingMe.world.worldobjects.Wall;
import processing.data.JSONArray;
import processing.data.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @brief Contains {@link Entity entities} within the same geometry.
 * @details
 * A
 *
 *
 * @todo Implement geometry and a viewport to be able to navigate.
 * @author Alex Knight (DemiKnight)
 * @since 0.1.1
 * @see World
 */
public class Level extends Stage
{
    public Level()
    {

    }

    protected Level(String id) {
        super(id);
    }

    /**
     * Convert each level into a Level object.
     *
     * Takes a JSON object containing a Meta, background and structure children.
     *
     * @param rawLevel JSON object containg all @ref Level information
     * @param levelIndex
     * @return Populated Level object.
     */
    public Level createLevel(JSONObject rawLevel, int levelIndex)
    {
        //Sets the ID for the level to the level index + the ID.
        String levelTag = levelIndex + ":" + rawLevel.getJSONObject("meta").getString("id");

        //Blank level to populate below.
        Level newLevel = new Level(levelTag);

        //Contains all Entities that need to be loaded for the Level to function properly.
        LinkedList<Entity> tempEntityToLoadList = new LinkedList<>();

        /* ################ Meta Data #####################*/
        /* ################ Structure Data #####################*/

        //The contains all commands to actually build the level and create the entities.
        JSONObject structure = rawLevel.getJSONObject("structure");

        //Will contain each building command.

        Iterator structureIt = structure.keyIterator();
        while (structureIt.hasNext())
        {
            String instructionKey = (String) structureIt.next();

            //Handle the command by passing it to the relevant function.
            switch (instructionKey)
            {
                case "create-wall":

                    handleCreateWall(tempEntityToLoadList,structure.getJSONArray(WorldHandler.WorldCommands.CommandBuildWall.getCommandRaw()),levelTag+":wall:");

                    break;
            }

        }


        /* ################ Background Data #####################*/


        newLevel.entitiesToLoad = tempEntityToLoadList.toArray(new Entity[0]);
        return newLevel;
    }

    /**
     *
     * @param listOfWalls Array containing information to create a single wall.
     */
    private void handleCreateWall(LinkedList<Entity> listToModify, JSONArray listOfWalls, String baseTag)
    {
        for (int levelArrayIndex = 0; levelArrayIndex < listOfWalls.size(); levelArrayIndex++)
        {
            listToModify.add(Wall.createWall(listOfWalls.getJSONArray(levelArrayIndex),baseTag+":"+levelArrayIndex));
        }

    }

}