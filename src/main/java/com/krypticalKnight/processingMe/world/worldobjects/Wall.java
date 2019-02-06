package com.krypticalKnight.processingMe.world.worldobjects;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.MetaData;
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
     * @brief Will be used when the parent Processing instance is set later on.
     *
     */
    public Wall()
    {
        super("Wall");
    }



    /**
     *
     * @param objectData
     * @param entityID
     * @return
     */
    public static Wall createWall(JSONArray objectData, String entityID)
    {
        Wall tempWall = new Wall();

        //Required Variables
        tempWall.wallStart = new EntityLocation(tempWall ,objectData.getInt(0),objectData.getInt(1));
        tempWall.wallEnd = new EntityLocation(tempWall ,objectData.getInt(2),objectData.getInt(3));

        tempWall.wallThickness = (byte) objectData.getInt(4,2);
        tempWall.colour = (objectData.get(5) != null ? Color.decode(objectData.getString(5)) : Color.BLACK);

        System.out.println(entityID);

        return tempWall;
    }

    @Override
    public void render(Application graphics, EntityLocation location)
    {
        graphics.fill(this.colour.getRed(), this.colour.getGreen(), this.colour.getBlue());
        graphics.line(wallStart.getxLocation(),wallStart.getyLocation(),wallEnd.getxLocation(),wallEnd.getyLocation());
    }
}
