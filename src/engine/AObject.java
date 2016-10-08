package engine;

/**
 * Created by Leo on 27.09.2016.
 */
public class AObject {
    private static long counter = 0;

    private long ID;

    public long getID() {
        return ID;
    }

    public AObject() {
        counter++;
        ID = counter;
    }
}
