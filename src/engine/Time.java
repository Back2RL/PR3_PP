package engine;

/**
 * Created by Leo on 27.09.2016.
 */

public class Time {

    public static final long NANOS_IN_SECOND = (long) 1E9;

    public static long getTime() {
        return System.nanoTime();
    }

    public static double getTimeSeconds(){
        return System.nanoTime() / (double) NANOS_IN_SECOND;
    }
}
