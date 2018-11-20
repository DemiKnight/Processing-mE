package com.krytpicalknight.processingMe;

import com.krytpicalknight.processingMe.render.Entity;
import com.krytpicalknight.processingMe.render.RenderManager;
import com.krytpicalknight.processingMe.render.ResourceManager;
import com.krytpicalknight.processingMe.render.ResourceRequirements;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Will be the place all entities are registered and any resources are requested.
 * Will also handle binding of keyboard shortcuts
 *
 * @author Alex K
 * @since 0.0.3
 * */
public class EntityManager {

    /**
     * Stores the all entities active in the application, including any rendered or unrendered.
     */
    private List<Entity> entityList;

    /**
     * Used to lookup the Entity ID's to the relvant ones store within the <tt>entityList</tt>.
     */
    private HashMap<String, Integer> nameLookup;

    /**
     * Reference to the renderManager, to setup rendered entities.
     */
    private RenderManager renderManager;

    /**
     * Reference to the ResourceManager, allowing any resources required by a entity to be stored here.
     */
    private ResourceManager resourceM;

    /**
     * To initialise all variables and references.
     * @param renderM Reference to the RenderManager
     * @param resourceManager Reference to the ResourceManager
     */
    public EntityManager(RenderManager renderM, ResourceManager resourceManager)
    {
        this.renderManager = renderM;
        this.resourceM = resourceManager;

        entityList = new LinkedList<>();
    }

    /**
     * Register and store entities to be used later in the application.
     *
     * @param intendedRegistry A Class containing entities that need to be stored here.
     */
   public void Registry(EntityRegistry intendedRegistry)
   {
       intendedRegistry.RegisterEntities(this);
   }

    /**
     * Gather and store all resources required by the application.
     *
     * @implNote To be called after all entities are stored.
     */
   public void registerResource()
   {
       for (Entity entSelect: entityList )
       {
           if (entSelect instanceof ResourceRequirements) resourceM.addResource((ResourceRequirements) entSelect);
       }
   }

    /**
     * Gives a link to the main processing application to all entities, allowing for them to interact.
     *
     * @param parentInstance Link to main Processing instance
     */
   public void giveParentInstance(PApplet parentInstance)
   {
       for (Entity entitySelected:entityList)
       {
           entitySelected.setParentProcessing(parentInstance);
       }
   }

    /**
     * 
     */
   public void registerIDs()
   {
       nameLookup = new HashMap<>();

       for (int index = 0; index < entityList.size();index++)
       {
//           String temp = String.format("%d:%s", index, entityList.get(index).getID());
           nameLookup.put(String.format("%d:%s", index, entityList.get(index).getID()), index);
       }
   }

    /**
     * Add entity to registry & setup with <tt>renderManager</tt>
     * By default, will also setup the entity to update every frame.
     * <b>Warning, frame-rate may vary</b>
     * @param entToAdd Entity to add to list
     */
   public void addToRegistry(Entity entToAdd)
   {
       entityList.add(entToAdd);
       renderManager.addToRender(entToAdd,true);
   }

    /**
     * Add entity to registry & setup with <tt>renderManager</tt>
     *
     * <b>Warning, frame-rate may vary</b>
     * @param entToAdd Entity to add to list
     * @param willUpdate Whether the entity will be updated every frame.
     */
   public void addToRegistry(Entity entToAdd, boolean willUpdate)
   {
       entityList.add(entToAdd);
       renderManager.addToRender(entToAdd, willUpdate);
   }

    /**
     * Retrieve a stored entity. Using a numerical index.
     *
     * @param index Index of entity to retrieve.
     * @return The Entity at the given index.
     */
   public Entity getEntity(int index) { return this.entityList.get(index); }


    /**
     *
     * @deprecated
     * @return Entire List of entites currently being stored
     */
   public List<Entity> getEntityList()
   {
       return this.entityList;
   }

}
