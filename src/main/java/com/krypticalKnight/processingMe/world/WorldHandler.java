package com.krypticalKnight.processingMe.world;

import processing.data.JSONArray;
import processing.data.JSONObject;

import java.lang.reflect.Type;

public class WorldHandler {

    enum WorldCommands
    {
        FormatVersion("format-version"),

        /**
         * Main node containing global meta data for the world
         *
         * Mandatory or fail to load.
         */
        WorldMetaData("worldData"),
        /**
         * The name of the world, used to identify.
         *
         * Mandatory or fail to load.
         */
        WorldMetaDataName("name"),

        /**
         *
         */
        WorldMetaDataDefaultLevel("default-level"),

        /**
         * Indicate whether all entities should be loaded in the entire world or per level.
         * TODO Implement this when required behaviour from the entityManager is complete.
         */
        WorldMetaDataHeavyLoading("heavy-loading"),

        WorldMetaDataWidth("width"),
        WorldMetaDataHeight("height"),
        LevelTree("level"),
        LevelMeta("meta"),
        LevelMetaID("id"),
        LevelMetaWidth("width"),
        LevelMetaHeight("height"),
        LevelBackground("background"),
        LevelBackgroundType("type"),
        LevelBackgroundColour("colour"),
        LevelBackgroundImage("image"),

        LevelStructure("structure"),

        //Building Blocks
        /**
         * Takes an array as the value, means this:
         * - 0 - The start of wall, x location
         * - 1 - The start of wall, y location
         * - 2 - The end of wall, x location
         * - 3 - The end of wall, y location
         * - 4 - Thickness of the wall
         * - 5 - The colour # Could be null
         * - 6 - The resource ID for the # Could be null
         *
         */
        CommandBuildWall("create-wall"),

        /**
         * Create an entity
         */
        CommandCreateEntity("create-entity");

        private String commandRaw;

        WorldCommands(String text)
        {
            this.commandRaw = text;
        }

        public String getCommandRaw() {
            return this.commandRaw;
        }
    }


    public <T> T getData(WorldCommands dataToGet, JSONObject mainJSONFile, Type type)
    {
        switch (dataToGet)
        {

        case LevelMeta:


        case LevelMetaID:
            return (T) mainJSONFile.getJSONObject(WorldCommands.LevelMeta.getCommandRaw()).getString(WorldCommands.LevelMetaID.getCommandRaw());

        case LevelTree:
            return (T) mainJSONFile.getJSONObject(WorldCommands.LevelTree.getCommandRaw());

        case LevelMetaWidth:
            return (T) mainJSONFile.getJSONObject(WorldCommands.LevelMeta.getCommandRaw()).getString(WorldCommands.LevelMetaWidth.getCommandRaw());

        case LevelMetaHeight:
            return (T) mainJSONFile.getJSONObject(WorldCommands.LevelMeta.getCommandRaw()).getString(WorldCommands.LevelMetaHeight.getCommandRaw());

        case LevelBackground:


        case LevelBackgroundColour:


        case LevelBackgroundType:


        case LevelBackgroundImage:


        case LevelStructure:


        case WorldMetaData:
            return (T) mainJSONFile.getJSONObject(WorldCommands.WorldMetaData.getCommandRaw());

        case FormatVersion:
            return (T) mainJSONFile.getJSONObject(WorldCommands.WorldMetaData.getCommandRaw()).getString(WorldCommands.FormatVersion.getCommandRaw());

        case WorldMetaDataName:


        case WorldMetaDataHeight:


        case WorldMetaDataWidth:


        case CommandCreateEntity:

        case CommandBuildWall:


        }
        return null;
    }

    public String getStrData()
    {
        return null;
    }

    public void handle(WorldCommands command, JSONArray data)
    {
        switch (command)
        {
            case CommandBuildWall:
                HandleBuildWall(data);
                break;

            case CommandCreateEntity:
                HandleCreateEntity(data);
                break;
        }
    }


    private static void HandleBuildWall(JSONArray wallInfo)
    {

    }

    private static void HandleCreateEntity(JSONArray entityInfo)
    {

    }


}
