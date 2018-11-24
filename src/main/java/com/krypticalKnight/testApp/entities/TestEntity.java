package com.krypticalKnight.testApp.entities;

import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.render.Entity;
import com.krypticalKnight.processingMe.render.ResourceManager;
import com.krypticalKnight.processingMe.render.ResourceRequirements;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class TestEntity extends Entity implements ResourceRequirements {


    enum textures{
        up
    }

    private static HashMap<textures, Integer> textureMap = new HashMap<>();


    /**
     * BY default only sets up the parent processing instance
     */
    public TestEntity() {


        this.yLocation =20;
        this.xLocation=20;
    }


    public void render()
    {
//        parent.image(
//                ResourceManager.getPImageResource(textureMap.get(textures.up)), this.xLocation,this.yLocation, 30,30);
    }

    public void update()
    {
        this.xLocation+=1;
    }

    public void registerResources(@NotNull ResourceManager manager) {
        ResourceManager.stagePath("com.krypticalKnight.testApp/UP.png");

//        TestEntity.textureMap.put
//                (
//                textures.up,
//                manager.addResourceI(MainApp.getInstance().loadImage("com.krypticalKnight.testApp/UP.png"))
//                );
    }

}
