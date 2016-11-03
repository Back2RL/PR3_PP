package game;

import engine.Engine;
import engine.Game;
import engine.Input;
import engine.Renderer;
import engine.gfx.Image;

import java.awt.event.KeyEvent;

public class TestGame extends Game {

    private float testX = 0;
    private float testY = 0;
    private float mAxisForward = 0;
    private float mAxisRight = 0;

    private float speedX = 0;
    private float speedY = 0;

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

        float speed = 3.0f;
        speedX = FInterp(speedX, mAxisRight * 1000, (float) deltaTime, speed);
        speedY = FInterp(speedY, mAxisForward * 1000, (float) deltaTime, speed);

        testX = testX + speedX * (float) deltaTime;
        testY = testY + speedY * (float) deltaTime;

    }

    float FInterp(float curr, float target, float dt, float speed) {
        float diff = target - curr;
        return curr + diff * dt * speed;
    }

    @Override
    public void render(Engine en, Renderer r) {
        r.drawImage(testImage, (int) testX, (int) testY);
    }
}
