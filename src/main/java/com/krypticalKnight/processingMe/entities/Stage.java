package com.krypticalKnight.processingMe.entities;


import java.util.Iterator;
import java.util.LinkedList;

public abstract class Stage {

    protected Entity[] entitiesToLoad;

    protected LinkedList<EntityLocation> entityLocations = new LinkedList<>();

    private final String ID;

    protected Stage(String id) {
        ID = id;
    }

    public String getID() {
        return this.ID;
    }


    public void init(){}

    public Iterator<EntityLocation> getIterator()
    {
        return entityLocations.iterator();
    }
}