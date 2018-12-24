package com.krypticalKnight.processingMe.entities;

import com.krypticalKnight.processingMe.EntityRegistry;
import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.util.UseableResource;

import java.util.Iterator;
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
    private Entity[] entityList;

    /**
     * Will hold the <i>index location</i> of the entities to update before each com.krytpicalknight.processingMe.render pass. Will use <tt>updateEntities()</tt>
     * iterate and update all entities.
     */
    private List<Entity> updateList;

    /**
     * Used to lookup the Entity ID's to the relvant ones store within the <tt>entityList</tt>.
     */
    private UseableResource<Entity>[] entityDictionary;

    /**
     * Register and store entities to be used later in the application.
     *
     * @param intendedRegistry A Class containing entities that need to be stored here.
     */
   public void Registry(EntityRegistry intendedRegistry)
   {
       LinkedList<Entity> temporaryEntityList = new LinkedList<>();

       intendedRegistry.RegisterEntities(temporaryEntityList);

       entityDictionary = new UseableResource[temporaryEntityList.size()];

       for (int index = 0; index < entityDictionary.length; index++) {
           entityDictionary[index] = new UseableResource<Entity>(temporaryEntityList.get(index),temporaryEntityList.get(index).getID());
       }


       //Cast Linked list to an array.
       this.entityList = temporaryEntityList.toArray(new Entity[0]);
   }

   public Entity[] getEntities()
   {
       return this.entityList;
   }

   public Entity getEntity(String ID)
   {
       for (UseableResource<Entity> entityUseableResource : entityDictionary)
       {
           if (entityUseableResource.getID().equals(ID)) return entityUseableResource.getResoure();
       }

       MainApp.mainLogger.LogError("Unable to find Entity with given ID: "+ ID );
       return null;
   }

   public void runUpdate(StageManager stageM)
   {
       Iterator<EntityLocation> it =  stageM.getCurrentStage().getIterator();

       while (it.hasNext())
       {
           EntityLocation loc = it.next();

           loc.getEntityIndex().update(loc);

       }
   }
}


