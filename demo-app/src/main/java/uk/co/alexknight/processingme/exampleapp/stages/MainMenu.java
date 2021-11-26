package uk.co.alexknight.processingme.exampleapp.stages;

import uk.co.alexknight.processingme.Application;
import uk.co.alexknight.processingme.entities.Entity;
import uk.co.alexknight.processingme.entities.EntityLocation;
import uk.co.alexknight.processingme.entities.Stage;

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
