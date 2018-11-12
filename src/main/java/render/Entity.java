package render;

import processing.core.PApplet;

public interface Entity {

//    protected PApplet parent;

    RENDER_STATES renderState = RENDER_STATES.rendering;

    public void render();

    public void update();


}
