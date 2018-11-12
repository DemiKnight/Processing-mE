package render;

import processing.core.PApplet;

public class Entity {

    public RENDER_STATES renderState = RENDER_STATES.rendering;

    protected PApplet parent;

    public Entity(PApplet P)
    {
        this.parent = P;
    }
    /**
     *
     */
    public float xLocation = 0;

    /**
     * THe y location of the entity
     * */
    public float yLocation = 0;

    public void render(){}

    public void update(){}


}
