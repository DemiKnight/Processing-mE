package com.krypticalKnight.testApp.stages;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.Stage;
import com.krypticalKnight.processingMe.world.worldobjects.Wall;

public class MainMenu extends com.krypticalKnight.processingMe.util.MainMenu
{

    public void init()
    {
        this.entitiesToLoad = new Entity[] {Application.getEntityManager().getEntity("testEntity")};

        this.entityLocations.add(new EntityLocation(Application.getEntityManager().getEntity("testEntity"),20,20));
        this.entityLocations.add(new EntityLocation(Application.getEntityManager().getEntity(""), 40,40));
    }

}
