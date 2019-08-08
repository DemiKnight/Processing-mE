package com.krypticalKnight.processingMe.entities.template;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.MetaData;

public class EntityLocation extends MetaData {

    private Location entityLocation;

    public EntityLocation(Entity entityToRefnerece1, int defaultXLocation, int defaultYLocation)
    {
        //Base MetaData
        super(entityToRefnerece1);

        this.entityLocation = new Location(defaultXLocation, defaultYLocation);
    }
    public EntityLocation(Entity entityReference, Location newLocation)
    {
        super(entityReference);

        this.entityLocation = newLocation;
    }

    protected EntityLocation(){}

    public Location getEntityLocation()
    {
        return this.entityLocation;
    }
}
