package com.krypticalKnight.testApp.entities;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.render.ResourceRequirements;
import processing.core.PApplet;

public class TestEntity extends Entity implements ResourceRequirements {


    /**
     * BY default only sets up the parent processing instance
     */
    public TestEntity() {
        super("testEntity");
    }



    public void render(PApplet graphics, EntityLocation location)
    {
        graphics.ellipse(location.getxLocation(),location.getyLocation(),10,10);
    }

    public void update(EntityLocation loc)
    {
        loc.transformXLocation(2);
    }

    @Override
    public void initResource()
    {
        textureMapV.put("UP-Sprite","com.krypticalKnight.testApp/UP.png");
    }
}
