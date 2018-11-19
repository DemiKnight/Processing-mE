import render.Entity;
import render.RenderManager;
import render.ResourceManager;

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


    public EntityManager(RenderManager renderM, ResourceManager resourceManager)
    {
        this.renderManager = renderM;
        this.resourceM = resourceManager;


        entityList = new LinkedList<>();
    }

   public void Registry(EntityRegistry intendedRegistry)
   {
       intendedRegistry.RegisterEntities(this);
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
