package engine;


import engine.gfx.Color;
import engine.gfx.Image;

import java.awt.image.DataBufferByte;

public class Renderer {
    private int width, hight;
    private byte[] pixels;

    public Renderer(final Engine en) {
        width = en.WIDTH;
        hight = en.HEIGHT;
        pixels = ((DataBufferByte) en.getWindow().getImage().getRaster().getDataBuffer()).getData();

    }

    public void setPixel(final int x, final int y, final Color color) {

        if (x < 0 || !(x < width)
                || y < 0 || !(y < hight)
                || color.a == 0.0) {
            return;
        }
// Color: ABGR
        final int index = (x + y * width) * 4;
        pixels[index] = (byte) (color.a * 255);
        pixels[index + 1] = (byte) (color.b * 255);
        pixels[index + 2] = (byte) (color.g * 255);
        pixels[index + 3] = (byte) (color.r * 255);

    }

    public void clear() {
        for (int index = 0; index < pixels.length; index += 4) {
            // Color: ABGR
            pixels[index] = (byte) 255;
            pixels[index + 1] = 0;
            pixels[index + 2] = 0;
            pixels[index + 3] = 0;

        }
    }

    public void drawImage(final Image image, final int offX, final int offY) {
        for (int x = 0; x < image.width; ++x) {
            for (int y = 0; y < image.hight; ++y) {
                setPixel(x + offX, y + offY, image.pixels[x + y * image.width]);
            }
        }
    }
}
