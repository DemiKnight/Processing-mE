package com.krypticalKnight.processingMe.entities.template;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.world.worldobjects.Wall;

public class WallLocation extends EntityLocation {

    private float wallWidth = 0;
    private float wallHeight = 0;
    private float wallColour = 0xffffff;
    private byte wallStroke = 1;

    public WallLocation(Wall entityToRefnerece1, int defaultXLocation, int defaultYLocation) {
        super(entityToRefnerece1, defaultXLocation, defaultYLocation);
    }

    public WallLocation(Wall entityReference, int XLocation, int YLocation, int newWallWidth, int newWallHeight, int newWallColour, byte newWallStroke)
    {
        super(entityReference, XLocation, YLocation);
        this.wallHeight = newWallHeight;
        this.wallColour = newWallColour;
        this.wallStroke = newWallStroke;
        this.wallWidth = newWallWidth;
    }

    public WallLocation(Wall entityReference, int XLocation, int YLocation, float newWallWidth, float newWallHeight, float newWallColour, byte newWallStroke)
    {
        super(entityReference, XLocation, YLocation);
        this.wallHeight = newWallHeight;
        this.wallColour = newWallColour;
        this.wallStroke = newWallStroke;
        this.wallWidth = newWallWidth;
    }

    public WallLocation(Wall entityReference, Location newLocation, float newWallWidth, float newWallHeight, float newWallColour, byte newWallStroke)
    {
        super(entityReference, newLocation);
        this.wallHeight = newWallHeight;
        this.wallColour = newWallColour;
        this.wallStroke = newWallStroke;
        this.wallWidth = newWallWidth;
    }


    public float getWallWidth() {
        return wallWidth;
    }

    public void setWallWidth(float wallWidth) {
        this.wallWidth = wallWidth;
    }

    public float getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(float wallHeight) {
        this.wallHeight = wallHeight;
    }

    public float getWallColour() {
        return wallColour;
    }

    public void setWallColour(float wallColour) {
        this.wallColour = wallColour;
    }

    public byte getWallStroke() {
        return wallStroke;
    }

    public void setWallStroke(byte wallStroke) {
        this.wallStroke = wallStroke;
    }
}
