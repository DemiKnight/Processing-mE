package render;

import org.omg.IOP.ENCODING_CDR_ENCAPS;
import processing.core.PApplet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RenderManager {

    private List<Entity> renderList;

    private List<Integer> updateList;

    public RenderManager()
    {
        renderList = new LinkedList<Entity>();
        updateList = new LinkedList<Integer>();
    }

    public void renderFrame()
    {
        updateEntities();

        for (Entity selectEntity: renderList)
        {
            selectEntity.render();
        }
    }

    private void updateEntities()
    {
        Iterator<Integer> integerIterator = updateList.iterator();

        while (integerIterator.hasNext())
        {
            Integer tempInt = integerIterator.next();

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

    public void clear(PApplet parent)
    {
        parent.clear();
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
