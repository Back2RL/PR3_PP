package game;

import engine.Engine;
import engine.Game;
import engine.Input;
import engine.Renderer;
import engine.gfx.Image;
import engine.math.Double;

import java.awt.event.KeyEvent;

public class TestGame extends Game {

    private double testX = 0;
    private double testY = 0;
    private double mAxisForward = 0;
    private double mAxisRight = 0;
    private static final double accelSpeed = 2.0f;

    private double speedX = 0;
    private double speedY = 0;

    public static void main(String[] args) {
        // write your code here
        System.out.println(Thread.currentThread().getName() + ": Hello World!");
        Engine engine = new Engine(new TestGame());
        engine.start();
    }

    private Image testImage = new Image("/x.png");

    @Override
    public void update(Engine en, double deltaTime) {
        mAxisForward = (Input.isKeyDown(KeyEvent.VK_W) ? -1.0f : 0.0f)
                + (Input.isKeyDown(KeyEvent.VK_S) ? 1.0f : 0.0f);

        mAxisRight = (Input.isKeyDown(KeyEvent.VK_A) ? -1.0f : 0.0f)
                + (Input.isKeyDown(KeyEvent.VK_D) ? 1.0f : 0.0f);


        speedX = Double.fInterp(speedX, mAxisRight * 1000, deltaTime, accelSpeed);
        speedY = Double.fInterp(speedY, mAxisForward * 1000, deltaTime, accelSpeed);

        testX = testX + speedX * deltaTime;
        testY = testY + speedY * deltaTime;

    }



    @Override
    public void render(Engine en, Renderer r) {
        r.drawImage(testImage, (int) testX, (int) testY);
    }
}
