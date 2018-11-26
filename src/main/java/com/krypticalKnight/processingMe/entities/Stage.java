package com.krypticalKnight.processingMe.entities;

import java.util.LinkedList;

public abstract class Stage {

    protected String[] entitiesToLoad;

    protected EntityLocation[] entityLocations;

    private final String ID;

    protected Stage(String id) {
        ID = id;
    }

    public String getID() {
        return this.ID;
    }
}
