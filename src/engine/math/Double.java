package engine.math;

/**
 * Created by leonard on 05.11.16.
 */
public class Double {
    public final static double SMALL_NUMBER = 1E-9;

    public static double fInterp(final double curr, final double target, final double dt, final double speed) {
        if (Math.abs(curr - target) < SMALL_NUMBER) return target;
        final double diff = target - curr;
        return curr + diff * Math.min(1.0, dt) * speed;
    }
}
