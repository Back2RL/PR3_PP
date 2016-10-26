package game;

import engine.Engine;
import engine.Game;
import engine.Input;
import engine.Renderer;
import engine.gfx.Image;

import java.awt.event.KeyEvent;

public class TestGame extends Game {

    private int testX = 0;
    private int testY = 0;
    private float mAxisForward = 0;
    private float mAxisRight = 0;

    public static void main(String[] args) {
        // write your code here
        System.out.println(Thread.currentThread().getName() + ": Hello World!");
        Engine engine = new Engine(new TestGame());
        engine.start();
    }

    private Image testImage = new Image("/test.png");

    @Override
    public void update(Engine en, double deltaTime) {
        mAxisForward = (Input.isKeyDown(KeyEvent.VK_W) ? -1.0f : 0.0f)
                + (Input.isKeyDown(KeyEvent.VK_S) ? 1.0f : 0.0f);

        mAxisRight = (Input.isKeyDown(KeyEvent.VK_A) ? -1.0f : 0.0f)
                + (Input.isKeyDown(KeyEvent.VK_D) ? 1.0f : 0.0f);



        testX = (int) (testX + mAxisRight * 100 * deltaTime) % en.WIDTH;
        testY = (int) (testY + mAxisForward * 100 * deltaTime) % en.HEIGHT;

    }

    @Override
    public void render(Engine en, Renderer r) {

        r.drawImage(testImage, testX, testY);
    }
}
