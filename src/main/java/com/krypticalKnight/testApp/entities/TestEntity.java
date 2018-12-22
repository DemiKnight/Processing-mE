package com.krypticalKnight.testApp.entities;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.render.ResourceRequirements;
import processing.core.PApplet;

public class TestEntity extends Entity implements ResourceRequirements {


    /**
     * BY default only sets up the parent processing instance
     */
    public TestEntity() {
        super("testEntity");

        this.yLocation =20;
        this.xLocation=20;


    }



    public void render(Application graphics)
    {
//        parent.image(
//                ResourceManager.getPImageResource(textureMap.get(textures.up)), this.xLocation,this.yLocation, 30,30);
    }

    public void update()
    {
        this.xLocation+=1;
    }

    @Override
    public void initResource()
    {
        textureMapV.put("UP-Sprite","com.krypticalKnight.testApp/UP.png");
    }
}
