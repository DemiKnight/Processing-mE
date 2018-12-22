package com.krypticalKnight.processingMe.entities;

import com.krypticalKnight.processingMe.Application;
import com.krypticalKnight.processingMe.render.RENDER_STATES;
import com.krypticalKnight.processingMe.render.RenderManager;
import processing.core.PApplet;

/**
 * This is the superclass for every entity being rendered to the screen. Through this entity, all relevant rendering
 * and game information should be stored and executed.
 *
 * @author Alex Knight
 * @since 0.0.2
 * @see RenderManager
 */
public abstract class Entity {

    /**
     * Set's an ID for the entity, allow for quick lookup.
     */
    private final String ID;

    public String getID() {
        return this.ID;
    }

    /**
     * States whether the entity is being rendered or just existing in memory.
     *
     *
     * todo Add the Entity Manager
     * @implNote Need to add Entity Manager to allow for game logic to execute despite it not being rendered.
     */
    public RENDER_STATES renderState = RENDER_STATES.rendering;

    /**
     * Will be used when the parent Processing instance is set later on.
     */
    public Entity(String newID)
    {
        this.ID = newID;
    }

    /**
     * Will allow entity to draw to the main processing window.
     *
     * Not needed if the entity does not interact with Processing
     * @param p Sets the pointer to the main Processing instance, used to interact with the draw window.
     */
//    public void setParentProcessing(PApplet p)
//    {
//        this.parent = p;
//    }

    /**
     * The x Location of the entity
     */
    public float xLocation = 0;

    /**
     * THe y location of the entity
     * */
    public float yLocation = 0;

    /**
     * When called the entity will be drawn on the screen, using the relevant variables.
     *
     * This function is called after <tt>update()</tt> has finished updating the object instance.
     * @implNote Must be a <i>pure-function</i>, meaning it must not change the instance of the class
     */
    public void render(Application graphics){}

    /**
     * Controls whether the entity should be updated on this pass, and whether it should be <i>halted</i>.
     *
     * todo Control whether the the instance needs to be updated, depending on whether any variables have changed.
     * @implNote Must only contain conditions for the entity to com.krytpicalknight.processingMe.render, may be used to change <tt>renderState</tt>
     * @return <tt>true</tt> if all entity update conditions are met.
     */
    private boolean canUpdate()
    {
        return true;
    }

    /**
     * Will change the variables within the class instance.
     * @implNote Will changed the variables of the instance, must be a <i>impure-function</i>
     */
    public void update()
    {
        if(!canUpdate()) return;
    }

}
