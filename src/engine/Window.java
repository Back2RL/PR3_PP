package engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by Leo on 02.10.2016.
 */
public class Window {

    private JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;

    private Thread RenderThread;

    public Window(final Engine en) {
        image = new BufferedImage(en.WIDTH, en.HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        canvas = new Canvas();
        Dimension dim = new Dimension((int) (en.WIDTH * en.SCALE), (int) (en.HEIGHT * en.SCALE));
        canvas.setPreferredSize(dim);
        canvas.setMaximumSize(dim);
        canvas.setMinimumSize(dim);

        frame = new JFrame(en.TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        BufferCapabilities.FlipContents fc = BufferCapabilities.FlipContents.COPIED;
        BufferCapabilities bc = new BufferCapabilities(new ImageCapabilities(true), new ImageCapabilities(true), fc);

        try {
            canvas.createBufferStrategy(2, bc);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        //canvas.createBufferStrategy(3);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public boolean finishedDisplaying() {
        return RenderThread == null || !RenderThread.isAlive();
    }

    public void update() {
        RenderThread = new Thread(() -> {
            g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
            bs.show();
        });
        RenderThread.start();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void cleanUp() {
        g.dispose();
        bs.dispose();
        image.flush();
        frame.dispose();
    }
}
