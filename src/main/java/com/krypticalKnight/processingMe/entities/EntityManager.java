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
     * @brief Temporary store of entities, to be modified during loading. Will be destroyed when complete.
     *
     * When application is loading, all required entities should be added to this list. When the application is finished loading,
     * entities will be moved to the @ref entityList
     *
     */
    private LinkedList<Entity> temporaryEntityList = new LinkedList<>();

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
//       LinkedList<Entity> temporaryEntityList = new LinkedList<>();

       intendedRegistry.RegisterEntities(temporaryEntityList);

   }
   public void RegisterEntity(Entity newEntity)
   {
       if(temporaryEntityList != null)
       {
           temporaryEntityList.add(newEntity);
       }
       else
       {
           MainApp.mainLogger.LogError("Attempting to register entity post preInit! " + newEntity.getID());
       }
   }

    /**
     * Put all entities held in temp list into a single array.
     */
   public void FinaliseRegistry()
   {
       this.entityList = temporaryEntityList.toArray(new Entity[0]);

       entityDictionary = new UseableResource[temporaryEntityList.size()];

       for (int index = 0; index < entityDictionary.length; index++) {
           entityDictionary[index] = new UseableResource<Entity>(entityList[index], entityList[index].getID());
       }

       //No Longer needed
       this.temporaryEntityList = null;
   }

   public Entity[] getEntities()
   {
       if (temporaryEntityList == null)
       {
           return this.entityList;
       } else {
           return temporaryEntityList.toArray(new Entity[0]);
       }
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


