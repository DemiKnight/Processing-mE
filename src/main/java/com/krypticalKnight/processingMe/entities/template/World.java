package com.krypticalKnight.processingMe.entities.template;

import com.krypticalKnight.processingMe.entities.Stage;
import processing.data.JSONObject;

public class World extends Stage {

    private final int WIDTH_WORLD;
    private final int HEIGHT_WORLD;

    public void loadWorld(JSONObject rawWorldData)
    {

    }

    protected World(String id, int width_world, int height_world) {
        super(id);
        WIDTH_WORLD = width_world;
        HEIGHT_WORLD = height_world;
    }

    public int getHeight()
    {
        return this.HEIGHT_WORLD;
    }

    public int getWidth()
    {
        return this.WIDTH_WORLD;
    }

}
