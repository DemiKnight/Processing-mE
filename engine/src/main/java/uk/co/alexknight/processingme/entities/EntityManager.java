package uk.co.alexknight.processingme.entities;

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

//
////    /**
////     * Gives a link to the main processing application to all entities, allowing for them to interact.
////     *
////     * @param parentInstance Link to main Processing instance
////     */
////   public void giveParentInstance(PApplet parentInstance)
////   {
////       for (Entity entitySelected:entityList)
////       {
////           entitySelected.setParentProcessing(parentInstance);
////       }
////   }
//
//    /**
//     *
//     */
//   public void registerIDs()
//   {
//       nameLookup = new HashMap<>();
//
//       for (int index = 0; index < entityList.size();index++)
//       {
//           nameLookup.put(String.format("%d:%s", index, entityList.get(index).getID()), index);
//       }
//   }
//
//   public void updateEntities()
//   {
//       for (Entity entSelect: entityList)
//       {
//           entSelect.update();
//       }
//   }
//
//    /**
//     * Add entity to registry & setup with <tt>renderManager</tt>
//     * By default, will also setup the entity to update every frame.
//     * <b>Warning, frame-rate may vary</b>
//     * @param entToAdd Entity to add to list
//     */
//   public void addToRegistry(Entity entToAdd)
//   {
//       entityList.add(entToAdd);
////       renderManager.addToRender(entityList.size()-1);
//       updateList.add(entityList.size()-1);
//   }
//
//    /**
//     * Add entity to registry & setup with <tt>renderManager</tt>
//     *
//     * <b>Warning, frame-rate may vary</b>
//     * @param entToAdd Entity to add to list
//     * @param willUpdate Whether the entity will be updated every frame.
//     */
//   public void addToRegistry(Entity entToAdd, boolean willUpdate)
//   {
//       entityList.add(entToAdd);
//       if (willUpdate) updateList.add(entityList.size()-1);
//   }
//
//    /**
//     * Retrieve a stored entity. Using a numerical index.
//     *
//     * @param index Index of entity to retrieve.
//     * @return The Entity at the given index.
//     */
//   public Entity getEntity(int index) { return this.entityList.get(index); }
//
//   public static Entity getEntity(String ID) {return entityList.get(0);}
//
//    public static int getEntityIndex(String ID) {return 0;}
//    /**
//     *
//     * @deprecated
//     * @return Entire List of entites currently being stored
//     */
//   public List<Entity> getEntityList()
//   {
//       return this.entityList;
//   }
//
//    public void addToUpdate(Integer indexOfEnt)
//    {
//        updateList.add(indexOfEnt);
//    }
//
//    public void addToUpdate(Entity entToAdd)
//    {
//        if(entityList.contains(entToAdd))
//        {
//            updateList.add(entityList.indexOf(entToAdd));
//        }
//    }

}


