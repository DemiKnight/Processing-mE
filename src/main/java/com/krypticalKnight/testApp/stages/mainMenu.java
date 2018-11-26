package com.krypticalKnight.testApp.stages;

import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.Stage;

public class mainMenu extends Stage {

    public mainMenu()
    {
        super("mainMenu");
        this.entitiesToLoad = new String[] {"testEntity"};
        this.entityLocations = new EntityLocation[] {
                EntityLocation.createLocation("testEntity", 20,20)
        };
    }

}
