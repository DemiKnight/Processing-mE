package render;

import org.omg.IOP.ENCODING_CDR_ENCAPS;

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
        for(Integer selectElement : updateList)
        {
            if (renderList.get(selectElement).renderState == RENDER_STATES.halted)
            {
                renderList.remove(renderList.get(selectElement));
            }
            else
            {
                renderList.get(selectElement).update();
            }
        }
    }

    public void addToRender(Entity entToAdd)
    {
        renderList.add(entToAdd);
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
