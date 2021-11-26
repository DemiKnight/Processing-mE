package uk.co.alexknight.processingme.entities;

public class EntityLocation {

    private int xLocation;

    private int yLocation;

    private final Entity entity;

    public EntityLocation(Entity entityToRefnerece1, int defaultXLocation, int defaultYLocation)
    {
        this.entity = entityToRefnerece1;
        this.xLocation = defaultXLocation;
        this.yLocation = defaultYLocation;
    }

    public static EntityLocation createLocation(Entity entityToTrack, int xNewLoc, int yNewLoc)
    {
        return new EntityLocation(entityToTrack,xNewLoc,yNewLoc);
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

    public Entity getEntityIndex() {
        return entity;
    }
}
