package game;

import engine.Engine;
import engine.Game;
import engine.Input;
import engine.Renderer;
import engine.gfx.Image;

import java.awt.event.KeyEvent;

public class TestGame extends Game {

    private int testX = 0;

    public static void main(String[] args) {
        // write your code here
        System.out.println(Thread.currentThread().getName() + ": Hello World!");
        Engine engine = new Engine(new TestGame());
        engine.start();
    }

    private Image testImage = new Image("/test.png");

    @Override
    public void update(Engine en, double deltaTime) {
        if (Input.isKeyPressed(KeyEvent.VK_A)) {
            System.out.println("A is down");
        }

        testX = (int) (testX + 100*deltaTime) % en.WIDTH;

    }

    @Override
    public void render(Engine en, Renderer r) {

        r.drawImage(testImage, testX, 50);
    }
}
