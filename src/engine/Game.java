package engine;

/**
 * Created by Leo on 27.09.2016.
 */
public abstract class Game {

    // update all components in world
    public abstract void update(final Engine en, final double deltaTime);

    // display all components on screen
    public abstract void render(final Engine en, final Renderer r);

}
