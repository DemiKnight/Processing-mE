package uk.co.alexknight.processingme.exampleapp.entities;

import processing.core.PApplet;
import uk.co.alexknight.processingme.entities.Entity;
import uk.co.alexknight.processingme.entities.EntityLocation;
import uk.co.alexknight.processingme.render.ResourceRequirements;

public class TestEntity extends Entity implements ResourceRequirements {


    /**
     * BY default only sets up the parent processing instance
     */
    public TestEntity() {
        super("testEntity");

        this.yLocation =20;
        this.xLocation=20;


    }



    public void render(PApplet graphics, EntityLocation location)
    {
        graphics.ellipse(location.getxLocation(),location.getyLocation(),10,10);

//        parent.image(
//                ResourceManager.getPImageResource(textureMap.get(textures.up)), this.xLocation,this.yLocation, 30,30);
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
