package engine.math;

/**
 * Created by leonard on 05.11.16.
 */
public class Float {
    public final static float SMALL_NUMBER = 1E-9f;

    public static float hfInterp(final float curr, final float target, final float dt, final float speed) {
        if (Math.abs(curr - target) < SMALL_NUMBER) return target;
        final float diff = target - curr;
        return curr + diff * Math.min(1.0f, dt) * speed;
    }
}
