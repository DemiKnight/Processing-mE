package com.krypticalKnight.processingMe.render;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.StageManager;

import java.util.Iterator;
import java.util.List;

/**
 * Used to control what <tt>Entity</tt> can be rendered and updated within each frame.
 *
 * TODO Separate the game logic update() from processing thread.
 * @author Alex Knight
 * @since 0.0.2
 * @see Entity
 */
public class RenderManager {

    /**
     * Will hold the entities that are in need of being rendered. Every frame, it will call <tt>renderFrame()</tt>
     * TODO MOve the entities into their own Entity Manager, to move towards game and graphic seperation.
     */
    private List<Entity> renderList;

    private ResourceManager resourceM;

    public RenderManager()
    {
        resourceM = new ResourceManager();
        //Linked list will be used as the collection type to allow for dynamic entity addition/subtraction
    }

    public ResourceManager getResourceM() {
        return this.resourceM;
    }

    public void draw(StageManager stageM, Application graphics)
    {
        Iterator<EntityLocation> it = stageM.getCurrentStage().getIterator();

        while (it.hasNext())
        {
            EntityLocation tempLoc = it.next();

            tempLoc.getEntityIndex().render(graphics,tempLoc);
        }
    }


}
