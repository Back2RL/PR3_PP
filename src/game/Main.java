package game;

import engine.Engine;
import engine.Game;
import engine.Input;
import engine.Renderer;
import engine.gfx.Image;

import java.awt.event.KeyEvent;

public class Main extends Game {

    public static void main(String[] args) {
        // write your code here
        System.out.println(Thread.currentThread().getName() + ": Hello World!");
        Engine engine = new Engine(new Main());
        engine.start();
    }

    private Image testImage = new Image("/test.png");

    @Override
    public void update(Engine en, double deltaTime) {
        if (Input.isKeyPressed(KeyEvent.VK_A)) {
            System.out.println("A is down");
        }


    }

    @Override
    public void render(Engine en, Renderer r) {
        r.drawImage(testImage, 60, 200);
    }
}
