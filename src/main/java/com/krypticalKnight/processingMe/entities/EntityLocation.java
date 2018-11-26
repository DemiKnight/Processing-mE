package com.krypticalKnight.processingMe.entities;

public class EntityLocation {

    private int xLocation = 0;

    private int yLocation = 0;

    private int entityIndex;

    public EntityLocation(int entityToRefnerece1, int defaultXLocation, int defaultYLocation)
    {
        this.entityIndex = entityToRefnerece1;
        this.xLocation = defaultXLocation;
        this.yLocation = defaultYLocation;
    }

    public static EntityLocation createLocation(int entityIndex, int xNewLoc, int yNewLoc)
    {
        return new EntityLocation(entityIndex,xNewLoc,yNewLoc);
    }
    public static EntityLocation createLocation(String entityID, int xNewLoc, int yNewLoc)
    {
        return new EntityLocation(EntityManager.getEntityIndex(entityID),xNewLoc,yNewLoc);
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    public int getEntityIndex() {
        return entityIndex;
    }
}
