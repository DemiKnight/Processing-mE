package com.krytpicalknight.processingMe.test;

import processing.core.PApplet;
import processing.core.PImage;
import com.krytpicalknight.processingMe.render.Entity;
import com.krytpicalknight.processingMe.render.ResourceRequirements;

import java.util.List;

public class TestEntity extends Entity implements ResourceRequirements {
    /**
     * BY default only sets up the parent processing instance
     *
     * @param P main processing instance
     */
    public TestEntity(PApplet P) {
        super(P);

        this.yLocation =20;
        this.xLocation=20;


        TestEntity.ID = "TestEntity";
    }

    public void render()
    {
        parent.ellipse(xLocation,yLocation,10,10);
    }


    @Override
    public void registerResourcesPImage(List<PImage> pImageList) {
        System.out.println("Registering Resources");
    }
}
