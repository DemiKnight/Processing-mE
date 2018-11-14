package render;

import processing.core.PApplet;

import java.util.Iterator;
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
    private List<Entity> renderList;

    /**
     * Will hold the <i>index location</i> of the entities to update before each render pass. Will use <tt>updateEntities()</tt>
     * iterate and update all entities.
     */
    private List<Integer> updateList;

    public RenderManager()
    {
        renderList = new LinkedList<Entity>();
        updateList = new LinkedList<Integer>();
        //Linked list will be used as the collection type to allow for dynamic entity addition/subtraction
    }

    /**
     * Using <tt>renderList</tt> will iterate through and run the <tt>render()</tt> method on each entity in the list.
     * @apiNote Will run <tt>updateEntities()</tt> every frame to update necessary components.
     */
    public void renderFrame()
    {
        updateEntities();

        for (Entity selectEntity: renderList)
        {
            selectEntity.render();
        }
    }

    /**
     * WIll run through each entity and run <tt>update()</tt>.
     * @apiNote If the entity has a <tt>renderState</tt>  set to <tt>RENDER_STATES.halted</tt>, will not update and remove from rendering.
     */
    private void updateEntities()
    {
        Iterator<Integer> integerIterator = updateList.iterator();
        Integer tempInt = 0;

        while (integerIterator.hasNext())
        {
            tempInt = integerIterator.next();

            if (renderList.get(tempInt).renderState == RENDER_STATES.halted)
            {
                integerIterator.remove();
            }
            else
            {
                renderList.get(tempInt).update();
            }
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

    public void addToRender(Entity entToAdd, boolean update)
    {
        renderList.add(entToAdd);
        if(update) updateList.add(renderList.size()-1);
    }

    public void removeFromRender(Entity entToRemove)
    {
        renderList.remove(entToRemove);
    }

    public void removeFromRender(int index)
    {
        renderList.remove(index);
    }

    public void addToUpdate(Integer indexOfEnt)
    {
        updateList.add(indexOfEnt);
    }

    public void addToUpdate(Entity entToAdd)
    {
        if(renderList.contains(entToAdd))
        {
            updateList.add(renderList.indexOf(entToAdd));
        }
    }
}
