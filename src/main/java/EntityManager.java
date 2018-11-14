import render.Entity;
import render.RenderManager;

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


    private List<Entity> entityList;
    private RenderManager renderManager;



    public EntityManager(RenderManager renderM)
    {
        this.renderManager = renderM;

        entityList = new LinkedList<>();
    }

   public void Registry()
   {

   }

   public void Registry(EntityRegistry intendedRegistry)
   {

   }

}
