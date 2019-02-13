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
     * A copy of entities that this {@link Stage} needs. These will only be used to
     *
     */
    protected Entity[] entitiesToLoad;

    /**
     * @brief Relative locations  {@link Entity entities}
     */
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
        System.out.println(entityLocations.size());
        return entityLocations.iterator();
    }
}