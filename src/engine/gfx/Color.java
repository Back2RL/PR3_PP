package engine.gfx;

/**
 * Created by Leo on 02.10.2016.
 */
public class Color {
    public static Color BLACK = new Color(1,0,0,0);
    public static Color WHITE = new Color(1,1,1,1);

    public float a,r,g,b;

    public Color(float a, float r, float g, float b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
