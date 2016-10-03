package engine.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Leo on 02.10.2016.
 */
public class Image {
    public int width, hight;
    public Color[] pixels;

    private static final float DIV_255 = (float) (1.0 / 255.0);

    public Image(final String path) {

        BufferedImage image = null;

        try {
            image = ImageIO.read(Image.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        hight = image.getHeight();
        int[] p = image.getRGB(0, 0, width, hight, null, 0, width);
        pixels = new Color[p.length];
        for (int i = 0; i < p.length; ++i) {
            pixels[i] = new Color((0xff & (p[i] >> 24)) * DIV_255,
                    (0xff & (p[i] >> 16)) * DIV_255,
                    (0xff & (p[i] >> 8)) * DIV_255,
                    (0xff & p[i]) * DIV_255);
        }
        image.flush();
    }
}
