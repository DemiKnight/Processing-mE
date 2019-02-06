package com.krypticalKnight.processingMe.entities;

public class EntityLocation extends MetaData {

    private int xLocation;

    private int yLocation;

    public EntityLocation(Entity entityToRefnerece1, int defaultXLocation, int defaultYLocation)
    {
        //Base MetaData
        super(entityToRefnerece1);

        this.xLocation = defaultXLocation;
        this.yLocation = defaultYLocation;
    }

    public int getxLocation() {
        return this.xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public void transformXLocation(int transformX)
    {
        this.xLocation += transformX;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public void transformYLocation(int transformY)
    {
        this.yLocation += transformY;
    }
}
