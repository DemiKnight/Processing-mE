import processing.core.PApplet;
import render.Entity;

public class TestEntity extends Entity {
    /**
     * BY default only sets up the parent processing instance
     *
     * @param P main processing instance
     */
    public TestEntity(PApplet P) {
        super(P);

        this.yLocation =20;
        this.xLocation=20;
    }

    public void render()
    {
        parent.ellipse(xLocation,yLocation,10,10);
    }
}
