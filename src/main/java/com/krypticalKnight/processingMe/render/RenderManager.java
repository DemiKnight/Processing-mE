package com.krypticalKnight.processingMe.render;

import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.StageManager;
import processing.core.PApplet;

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

    public void draw(StageManager stageM, PApplet graphics)
    {
        Iterator<EntityLocation> it = stageM.getCurrentStage().getIterator();

        while (it.hasNext())
        {
            EntityLocation tempLoc = it.next();

            tempLoc.getEntityIndex().render(graphics,tempLoc);
        }
    }


    //    public void init()
//    {
//        registerResource();
//    }

//    /**
//     * Using <tt>renderList</tt> will iterate through and setupApplication the <tt>com.krytpicalknight.processingMe.render()</tt> method on each entity in the list.
//     * @apiNote Will setupApplication <tt>updateEntities()</tt> every frame to update necessary components.
//     */
//    public void renderFrame()
//    {
////        for (Integer indexPointer: renderList)
////        {
//////            MainApp.getEntityM().getEntity(indexPointer).render();
////        }
//    }
//
//    public void renderFrame(PApplet parentGraphics)
//    {
//
//    }
//
//    /**
//     * Gather and store all resources required by the application.
//     *
//     * @implNote To be called after all entities are stored.
//     */
//    private void registerResource()
//    {
//        ResourceManager.LoadResources();
////        for (Entity entSelect: MainApp.getEntityM().getEntityList() )
////        {
////            if (entSelect instanceof ResourceRequirements) resourceM.addResource((ResourceRequirements) entSelect);
////        }
//    }
//
//    /**
//     * Used to clear the screen, might be able to clear specific sections in the future
//     * @param parent Link to Processing runtime
//     */
//    public void clear(PApplet parent)
//    {
//        parent.clear();
//        //TODO Use a config to set the beginning background colour
//        parent.background(155);
//    }
//
//    public void addToRender(Integer entToAdd)
//    {
//        renderList.add(entToAdd);
////        if(update) updateList.add(renderList.size()-1);
//    }
//
//    public void removeFromRender(Entity entToRemove)
//    {
//        renderList.remove(entToRemove);
//    }
//
//    public void removeFromRender(int index)
//    {
//        renderList.remove(index);
//    }


}
