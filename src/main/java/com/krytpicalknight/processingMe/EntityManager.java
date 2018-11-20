package com.krytpicalknight.processingMe;

import com.krytpicalknight.processingMe.render.Entity;
import com.krytpicalknight.processingMe.render.RenderManager;
import com.krytpicalknight.processingMe.render.ResourceManager;
import com.krytpicalknight.processingMe.render.ResourceRequirements;
import processing.core.PApplet;

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
     *
     */
    private List<Entity> entityList;

    /**
     *
     */
    private RenderManager renderManager;

    private ResourceManager resourceM;

//    private PApplet parent;

    public EntityManager(RenderManager renderM, ResourceManager resourceManager)
    {
        this.renderManager = renderM;
//        this.parent = P;
        this.resourceM = resourceManager;

        entityList = new LinkedList<>();
    }

   public void Registry(EntityRegistry intendedRegistry)
   {
       intendedRegistry.RegisterEntities(this);
   }

   public void registerResource()
   {
       for (Entity entSelect: entityList )
       {
           if (entSelect instanceof ResourceRequirements) resourceM.addResource((ResourceRequirements) entSelect);
       }
   }

   public void giveParentInstance(PApplet PA)
   {
       for (Entity entitySelected:entityList)
       {
           entitySelected.setParentProcessing(PA);
       }
   }

   public void addToRegistry(Entity entToAdd)
   {
       entityList.add(entToAdd);
       renderManager.addToRender(entToAdd,true);
   }

   public void addToRegistry(Entity entToAdd, boolean willUpdate)
   {
       entityList.add(entToAdd);
       renderManager.addToRender(entToAdd, willUpdate);
   }

   public Entity getEntity(int index) { return this.entityList.get(index); }

   public List<Entity> getEntityList()
   {
       return this.entityList;
   }

}
