package com.krytpicalknight.processingMe.render;

import com.krytpicalknight.processingMe.MainApp;
import processing.core.PApplet;

import java.util.LinkedList;
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
    private List<Integer> renderList;



    private ResourceManager resourceM;

    public RenderManager(ResourceManager resourceManager)
    {
        this.renderList = new LinkedList<Integer>();
        this.resourceM = resourceManager;

        //Linked list will be used as the collection type to allow for dynamic entity addition/subtraction
    }

    public void init()
    {
        registerResource();
    }

    /**
     * Using <tt>renderList</tt> will iterate through and run the <tt>com.krytpicalknight.processingMe.render()</tt> method on each entity in the list.
     * @apiNote Will run <tt>updateEntities()</tt> every frame to update necessary components.
     */
    public void renderFrame()
    {
        for (Integer indexPointer: renderList)
        {
            MainApp.getEntityM().getEntity(indexPointer).render();
        }
    }

    /**
     * Gather and store all resources required by the application.
     *
     * @implNote To be called after all entities are stored.
     */
    private void registerResource()
    {
        for (Entity entSelect: MainApp.getEntityM().getEntityList() )
        {
            if (entSelect instanceof ResourceRequirements) resourceM.addResource((ResourceRequirements) entSelect);
        }
    }

    /**
     * Used to clear the screen, might be able to clear specific sections in the future
     * @param parent Link to Processing runtime
     */
    public void clear(PApplet parent)
    {
        parent.clear();
        //TODO Use a config to set the beginning background colour
        parent.background(155);
    }

    public void addToRender(Integer entToAdd)
    {
        renderList.add(entToAdd);
//        if(update) updateList.add(renderList.size()-1);
    }

    public void removeFromRender(Entity entToRemove)
    {
        renderList.remove(entToRemove);
    }

    public void removeFromRender(int index)
    {
        renderList.remove(index);
    }


}
