package engine;

/**
 * Created by Leo on 27.09.2016.
 */
public class Object {
    private static long ObjectCounter = 0;

    private long ID;

    public long getID() {
        return ID;
    }

    public Object() {
        ObjectCounter++;
        ID = ObjectCounter;
    }
}
