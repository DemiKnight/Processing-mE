package com.krypticalKnight.processingMe.world.worldobjects;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import processing.core.PImage;
import processing.data.JSONArray;

import java.awt.*;

public class Wall extends Entity {

    private EntityLocation wallStart;
    private EntityLocation wallEnd;

    private byte wallThickness;

    private Color colour;
    private PImage resourcel;

    /**
     * Will be used when the parent Processing instance is set later on.
     *
     * @param newID
     */
    public Wall(String newID) {
        super(newID);
    }

    public static Wall createWall(JSONArray objectData, String entityID)
    {
        Wall tempWall = new Wall(entityID);

        //Required Variables
        tempWall.wallStart = new EntityLocation(tempWall,objectData.getInt(0),objectData.getInt(1));
        tempWall.wallEnd = new EntityLocation(tempWall,objectData.getInt(2),objectData.getInt(3));

        tempWall.wallThickness = (byte) objectData.getInt(4,2);
        tempWall.colour = (objectData.get(5) != null ? Color.decode(objectData.getString(5)) : Color.BLACK);


        return tempWall;
    }

}
