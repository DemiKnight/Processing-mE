package com.krypticalKnight.processingMe.entities;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * @class Stage
 * @brief Controls what entities are currently loaded and being rendered.
 *
 * @details
 *
 * Contains entity states that will be loaded and updated by the {@link EntityManager}, and rendered using the {@link com.krypticalKnight.processingMe.render.RenderManager RenderManager}.
 *
 *
 * @author Alex Knight (DemiKnight)
 * @since 0.1.0
 * @see StageManager
 */
public abstract class Stage {

    /**
     * @brief Entities that are required by the level, devoid of any counter.
     *
     * @details
     *
     */
    protected Entity[] entitiesToLoad;

    protected LinkedList<EntityLocation> entityLocations = new LinkedList<>();

    private String ID;

    protected Stage(String id) {
        ID = id;
    }

    protected Stage()
    {

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