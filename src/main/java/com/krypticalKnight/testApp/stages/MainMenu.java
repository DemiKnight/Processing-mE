package com.krypticalKnight.testApp.stages;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.Stage;

public class MainMenu extends Stage {

    public MainMenu()
    {
        super("MainMenu");
    }

    public void init()
    {
        this.entitiesToLoad = new Entity[] {Application.getEntityManager().getEntity("testEntity")};

        this.entityLocations.add(EntityLocation.createLocation(Application.getEntityManager().getEntity("testEntity"),20,20));

    }

}
