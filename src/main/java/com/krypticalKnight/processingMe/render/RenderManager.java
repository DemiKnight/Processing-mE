package com.krypticalKnight.processingMe.render;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.GameState;
import com.krypticalKnight.processingMe.entities.Entity;
import com.krypticalKnight.processingMe.entities.EntityLocation;
import com.krypticalKnight.processingMe.entities.StageManager;
import com.krypticalKnight.processingMe.world.WorldHandler;
import com.krypticalKnight.processingMe.world.WorldManager;
import com.krypticalKnight.testApp.stages.MainMenu;
import processing.core.PApplet;

import java.util.Iterator;
import java.util.List;

/**
 * @brief  Used to control what {@link Entity} can be rendered and updated within each frame.
 *
 * @todo Separate the game logic update() from processing thread.
 *
 * @author Alex Knight
 * @since 0.0.2
 * @see Entity
 */
public class RenderManager
{

    /**
     * Will hold the entities that are in need of being rendered. Every frame, it will call <tt>renderFrame()</tt>
     * TODO MOve the entities into their own Entity Manager, to move towards game and graphic seperation.
     */
    private List<Entity> renderList;

    private ResourceManager resourceM;

    private WorldManager worldManager;
    private StageManager stageManagerRef;
    private PApplet mainRender;

    public RenderManager(StageManager newStageM, PApplet graphics, WorldManager worldM)
    {
        this.resourceM = new ResourceManager();
        this.stageManagerRef = newStageM;
        this.mainRender = graphics;
        this.worldManager = worldM;
        //Linked list will be used as the collection type to allow for dynamic entity addition/subtraction
    }

    public ResourceManager getResourceM() {
        return this.resourceM;
    }

    public void render()
    {
        Iterator<EntityLocation> entityLocationIterator;

        //Depending on the state, look for the different manager to use.
        if (Application.getCurrentState() != GameState.MainMenu)
        {
//            renderStage();
            entityLocationIterator = stageManagerRef.getCurrentStage().getIterator();
        }
        else
        {
//            renderWorld();
            System.out.println(worldManager);
            entityLocationIterator = worldManager.getCurrentWorld().getCurrentLevel().getIterator();
        }

        //Render the entities
        while (entityLocationIterator.hasNext())
        {
            EntityLocation entLoc = entityLocationIterator.next();

            entLoc.getTargetEntity().render(mainRender,entLoc);
        }
    }
}
