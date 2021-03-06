package engine;

import java.awt.*;

public class Engine implements Runnable {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    public static final double SCALE = 0.5;
    public static final String TITLE = "Engine";
    public static final int FRAME_CAP = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate();
    public static final double MAX_DELTA_TIME = 1.0 / FRAME_CAP;
    private Game game;
    private Thread gameThread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private boolean bIsRunning;
    private double GameTime = 0.0;

    public Engine(Game game) {
        bIsRunning = false;
        this.game = game;
    }

    public Window getWindow() {
        return window;
    }

    public void start() {
        if (bIsRunning) return;

        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        bIsRunning = true;

        GameTime = 0.0;
        double prevPartialSecond = 0;
        double currentPartialSecond;

        double startTime;
        double dt;
        double lastTime = Time.getTimeSeconds();

        double renderStartTime;
        double renderDt = 0;
        double renderLastTime = Time.getTimeSeconds();

        double passedFrameTime;

        final long sleepTime = 0;
        while (bIsRunning) {
            startTime = Time.getTimeSeconds();
            dt = startTime - lastTime;
            GameTime += dt;
            lastTime = startTime;


          /*  if (Window.isCloseRequested()) {
                stop();
            }*/

            game.update(this, dt);
            input.update();
            if (window.finishedDisplaying()) {
                renderStartTime = Time.getTimeSeconds();
                renderDt = renderStartTime - renderLastTime;
                renderLastTime = renderStartTime;

                renderer.clear();
                game.render(this, renderer);
                window.update();
            }

            passedFrameTime = Time.getTimeSeconds() - startTime;

            currentPartialSecond = GameTime - (int) GameTime;
            if (currentPartialSecond < prevPartialSecond) {
                System.out.println(Math.round(1.0 / dt) + " fps; " + Thread.currentThread().getName() + ": UpdateTime = " + passedFrameTime + "s");
                System.out.println(Math.round(1.0 / renderDt) + " fps; " + Thread.currentThread().getName() + ": RenderTime = " + renderDt + "s");
            }
            prevPartialSecond = currentPartialSecond;

            while (passedFrameTime < MAX_DELTA_TIME) {
                if (sleepTime > 0) {
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                passedFrameTime = Time.getTimeSeconds() - startTime;
            }
        }
    }

    public void stop() {
        if (!bIsRunning) return;
        bIsRunning = false;
    }

    private void cleanUp() {
        window.cleanUp();
    }
}
