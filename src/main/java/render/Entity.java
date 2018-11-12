package render;

public interface Entity {

    public RENDER_STATES renderState = RENDER_STATES.rendering;

    /**
     *
     */
    public float xLocation = 0;

    /**
     * THe y location of the entity
     * */
    public float yLocation = 0;

    public void render();

    public void update();


}
