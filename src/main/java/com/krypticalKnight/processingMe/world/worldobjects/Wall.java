package com.krypticalKnight.processingMe.world.worldobjects;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.template.EntityLocation;
import com.krypticalKnight.processingMe.entities.template.Location;
import com.krypticalKnight.processingMe.entities.template.WallLocation;
import com.krypticalKnight.processingMe.world.Level;
import processing.core.PApplet;
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
    public static Wall createWall(JSONArray objectData, String entityID, Level thisLevel)
    {
        Wall tempWall = new Wall();

//        Application.getEntityManager().addEntityLocation(new WallLocation
//                (
//                        Application.getEntityManager().getEntity("wall"),
//                        new Location(objectData.getInt(0),objectData.getInt(1)),
//                        (byte) objectData.getInt(4,2)
//                )
//        );
        WallLocation newLocation;


        int startX = objectData.getInt(0);
        int startY = objectData.getInt(1);

        int endX = objectData.getInt(2);
        int endY = objectData.getInt(3);

        int finalX = Math.round((float) (startX+endX)/2f);
        int finalY = Math.round((float) (startY+endY)/2f);

        newLocation = new WallLocation
                (
                        (Wall) Application.getEntityManager().getEntity("wall"),
                        new Location(finalX, finalY),
                        2,
                        2,
                        2,
                        (byte) objectData.getInt(4,2)
                );

        thisLevel.addToEntityLocations(newLocation);

        //Required Variables
        tempWall.wallStart = new WallLocation(tempWall ,objectData.getInt(0),objectData.getInt(1));
        tempWall.wallEnd = new WallLocation(tempWall ,objectData.getInt(2),objectData.getInt(3));

        tempWall.wallThickness = (byte) objectData.getInt(4,2);
        tempWall.colour = (objectData.get(5) != null ? Color.decode(objectData.getString(5)) : Color.BLACK);

        System.out.println(entityID);

        return tempWall;
    }

    @Override
    public void render(PApplet graphics, EntityLocation location)
    {
        graphics.fill(this.colour.getRed(), this.colour.getGreen(), this.colour.getBlue());
        graphics.line(wallStart.getEntityLocation().getxLocation(),wallStart.getEntityLocation().getyLocation(),wallEnd.getEntityLocation().getxLocation(),wallEnd.getEntityLocation().getyLocation());
    }
}
