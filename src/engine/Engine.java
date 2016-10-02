package engine;

/**
 * Created by Leo on 27.09.2016.
 */
public class Engine {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final String TITEL = "Engine";
    public static final int FRAME_CAP = 10;

    private boolean bIsRunning;
    private Game game;

    private double GameTime = 0.0;

    public Engine() {

        bIsRunning = false;
        game = new Game();
    }

    public void start() {
        if (bIsRunning) return;
        run();
    }

    public void stop() {
        if (!bIsRunning) return;
        bIsRunning = false;
    }

    private void run() {
        bIsRunning = true;

        GameTime = 0.0;
        double startTime = 0;
        double dt = 0;
        double lastTime = Time.getTimeSeconds();

        double passedFrameTime;
        final double maxDeltaTime = 1.0 / FRAME_CAP;

        final long sleepTime = 1;
        final double sleepCompensation = 0.001 * sleepTime;

        while (bIsRunning) {
            startTime = Time.getTimeSeconds();
            dt = startTime - lastTime;
            lastTime = startTime;


          /*  if (Window.isCloseRequested()) {
                stop();
            }*/

            System.out.println(Math.round(1.0 / dt) + " fps; ");

            game.input();
            game.update();
            Input.Update();
            render();

            passedFrameTime = Time.getTimeSeconds() - startTime;
            System.out.println("Rendertime = " + passedFrameTime + "s");
            while (passedFrameTime  +sleepCompensation < maxDeltaTime) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                passedFrameTime = Time.getTimeSeconds() - startTime;
            }

        }
    }

    private void render() {

        //RenderUtil.clearScreen();
        game.render();
        //Window.render();
    }

    private void cleanUp() {
        //    Window.dispose();
    }

    /*public static void main(String[] args) {
        System.out.println("starting engine...");
      Window.createWindow(WIDTH, HEIGHT, TITEL + " " + WIDTH + "x" + HEIGHT);

        MainComponent game = new MainComponent();
        game.start();
    }*/
}
