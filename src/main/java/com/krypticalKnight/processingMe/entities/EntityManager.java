/**
 * @page EntityTutorial Using Entities in Processing-eM
 * @tableofcontents
 * {@link com.krypticalKnight.processingMe.entities.Entity Entities} are the most basic form of objects possible
 * to be rendered. This page documents how to correctly use and implement them, and how they behave in related managers/classes.
 *
 * @section creatingEntities Getting started
 * @subsection creatingEntitiesRegistry Creating a Registry.
 * First create an new class, that implements {@link com.krypticalKnight.processingMe.EntityRegistry EntityRegistry}.
 * In the {@link com.krypticalKnight.processingMe.EntityRegistry.RegisterEntities RegisterEntities} method, append the given
 * list with the entities you have created.
 * @subsection creatingEntitiesLoading Loading Entities into the Application
 * In the class that extends {@link Application}, in the {@link com.krypticalKnight.processingMe.Application.preInit preInit()}, call the {@link com.krypticalKnight.processingMe.entities.EntityManager.Registry Registry()}
 * and pass in the {@link com.krypticalKnight.processingMe.entities.StageRegistry StageRegistry}, as a new instance.
 */
package com.krypticalKnight.processingMe.entities;

import com.krypticalKnight.processingMe.EntityRegistry;
import com.krypticalKnight.processingMe.MainApp;
import com.krypticalKnight.processingMe.entities.template.EntityLocation;
import com.krypticalKnight.processingMe.util.UseableResource;

import javax.naming.LinkLoopException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @brief Controls and stores all available entities, that can be used in any stages.
 *
 * @details
 *
 * Stores all the entities that can be used throughout the application, the not necessarily loaded.
 *
 *
 * @author Alex K
 * @since 0.0.3
 * @see Entity
 * */
@SuppressWarnings("JavadocReference")
public class EntityManager {

    /**
     * @brief Stores the all entities active in the application, including any rendered or unrendered.
     *
     * @details
     * Will store all possible Entities that can be used throughout the application. Even if they aren't being used with the
     * current {@link Stage}.
     */
    private Entity[] entityStore;

    /**
     * " @
     */
    private EntityLocation[] locationStore;

    /**
     * @brief Temporary store of entities, to be modified during loading. Will be destroyed when complete.
     *
     * @details
     * When application is loading, all required entities should be added to this list. When the application is finished loading,
     * entities will be moved to the {@link EntityManager.entityStore}
     *
     */
    private LinkedList<Entity> temporaryEntityList = new LinkedList<>();

    /*
     * This will store all locations and meta data for each object.
     */
    private LinkedList<EntityLocation> temporaryEntityLocation = new LinkedList<>();

    private EntityLocation[] entityLocationStore;

    public Iterator<EntityLocation> getEntityLocationIterator()
    {
         return temporaryEntityLocation.iterator();
    }

    public void addEntityLocation(EntityLocation newEntity)
    {
        if (temporaryEntityLocation != null)
        {
            //Game is still loading.|
            this.temporaryEntityLocation.add(newEntity);

        }else{
            //Past game main Level Loading
            LinkedList<EntityLocation> tempOldArray = new LinkedList<EntityLocation>(Arrays.asList(entityLocationStore));

            tempOldArray.add(newEntity);

            this.entityLocationStore = tempOldArray.toArray(new EntityLocation[0]);
        }
    }

    public void addEntityLocation(LinkedList<EntityLocation> newEntity)
    {
        if (temporaryEntityLocation != null)
        {
            //Game is still loading.|
            this.temporaryEntityLocation.addAll(newEntity);
        }else{
            //Past game main Level Loading
            LinkedList<EntityLocation> tempOldArray = new LinkedList<EntityLocation>(Arrays.asList(entityLocationStore));

            tempOldArray.addAll(newEntity);

            this.entityLocationStore = tempOldArray.toArray(new EntityLocation[0]);
        }
    }

//    /**
//     * Will hold the <i>index location</i> of the entities to update before each com.krytpicalknight.processingMe.render pass. Will use <tt>updateEntities()</tt>
//     * iterate and update all entities.
//     *
//     * TODO Decide whether this is needed.
//     */
//    private List<Entity> updateList;

    /**
     * @brief Used to lookup the Entity ID's to the relvant ones store within the <tt>entityStore</tt>.
     */
    private UseableResource<Entity>[] entityDictionary;

    /**
     * @brief Register and store entities to be used later in the application.
     * @details
     *
     *
     * @param intendedRegistry A Class containing entities that need to be stored here.
     */
   public void Registry(EntityRegistry intendedRegistry)
   {

       intendedRegistry.RegisterEntities(temporaryEntityList);

   }

    /**
     * @brief Add a single {@link Entity} to the registry,
     * @details
     * Add a {@link Entity} to the Registry,
     *
     * @note Normally used during {@link com.krypticalKnight.processingMe.world.World World} creation to add specific entities.
     * @warning Can only be called during {@link Application.preInit() preInit()}
     * @param[in] newEntity A new entity to be used later on in the application.
     */
   public void RegisterEntity(Entity newEntity)
   {
//       if(temporaryEntityList != null)
//       {
           temporaryEntityList.add(newEntity);
//       }
//       else
//       {
//           MainApp.mainLogger.LogError("Attempting to register entity post preInit! " + newEntity.getID());
//       }
   }



    /**
     * @brief Store registered entities in a permanent array.
     *
     * @details
     *
     * Takes all entities generated in {@link EntityManager:Registry}
     */
   public void FinaliseRegistry()
   {
       this.entityStore = temporaryEntityList.toArray(new Entity[0]);

       entityDictionary = new UseableResource[temporaryEntityList.size()];

       for (int index = 0; index < entityDictionary.length; index++) {
           entityDictionary[index] = new UseableResource<Entity>(entityStore[index], entityStore[index].getID());
       }

       entityLocationStore = temporaryEntityLocation.toArray(new EntityLocation[0]);

       //No Longer needed
       this.temporaryEntityList = null;
       this.temporaryEntityLocation = null;
   }

    /**
     * @brief Returns a list of all entities, currently registered.
     * @note Entities may not be loaded in the current stage.
     * @return List of all registered entities.
     */
   public Entity[] getEntities()
   {
       if (temporaryEntityList == null)
       {
           return this.entityStore;
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

    /**
     * @brief Update all entities currently loaded in the {@link Stage}
     * @details
     * Using an Iterator, to update each entity currently loaded.
     *
     * @param[out] stageM Access to the stages, through the use of a Iterator.
     */
   public void runUpdate(StageManager stageM)
   {
       Iterator<EntityLocation> it =  stageM.getCurrentStage().getIterator();

       while (it.hasNext())
       {
           EntityLocation loc = it.next();

           loc.getTargetEntity().update(loc);

       }
   }
}


