package com.krypticalKnight.processingMe.entities.template;

public class Location
{
    //TODO Setup a default spawn locaton in the config.
    private int xLocation;

    private int yLocation;

    public Location()
    {
        this.xLocation=0;
        this.yLocation=0;
    }
    public Location(int newXLocation, int newYLocation)
    {
        this.xLocation = newXLocation;
        this.yLocation = newYLocation;
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
    public void incrementY(int amount)
    {
        this.yLocation+=amount;
    }
    public void incrementX(int amount)
    {
        this.xLocation+=amount;
    }
}
