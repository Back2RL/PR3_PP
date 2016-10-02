package engine;

/**
 * Vector with 2 Dimensions, using Double
 */
public class Vector2D {
    private double x;
    private double y;

    public Vector2D() {
        x = y = 0.0;
    }

    public Vector2D(final Vector2D other) {
        this.x = other.x;
        this.y = other.y;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2D getSum(final Vector2D a, final Vector2D b) {
        Vector2D result = new Vector2D(a);
        return result.add(b);
    }

    /*
    * @return a new Vector with x = a.x * b.x and y = a.y * b.y
    */
    public static Vector2D getProduct(final Vector2D a, final Vector2D b) {
        Vector2D result = new Vector2D(a);
        return result.multiply(b);
    }

    public Vector2D scale(final double factor){
        this.x *= factor;
        this.y *= factor;
        return this;
    }

    public static Vector2D getQuotient(final Vector2D a, final Vector2D b) {
        Vector2D result = new Vector2D(a);
        return result.divide(b);
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public double dotProduct(final Vector2D other) {
        return x * other.x + y * other.y;
    }

    public Vector2D normalize() {
        double length = getLength();
        if(length <= 0.0){
            x = y = 0.0;
            System.out.println("Vector2D: failed to normalize: Div by 0");
            return this;
        }
        x /= length;
        y /= length;
        return this;
    }

    public Vector2D getNormalized() {
        Vector2D result = new Vector2D(this);
        return result.normalize();
    }

    public Vector2D rotate(final double angleDeg) {
        // deg to radians
        double rad = Math.toRadians(angleDeg);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        x = x * cos - y * sin;
        y = x * sin + y * cos;

        return this;
    }

    public Vector2D getRotated(final double angleDeg) {
        Vector2D result = new Vector2D(this);
        return result.rotate(angleDeg);
    }

    public Vector2D add(final Vector2D b) {
        x += b.x;
        y += b.y;
        return this;
    }

    /* multiplies the components of the Vector
    * x = x * b.x
    * y = y * b.y
    * @return the changed Vector
    */
    public Vector2D multiply(final Vector2D b) {
        x *= b.x;
        y *= b.y;
        return this;
    }

    public Vector2D divide(final Vector2D b) {
        if (b.x == 0 || b.y == 0) {
            System.out.println("Vector2D: Div by 0; Division not executed");
            return this;
        }
        x /= b.x;
        y /= b.y;
        return this;
    }

    public Vector2D substract(final Vector2D b) {
        x -= b.getX();
        y -= b.getY();
        return this;
    }

    public static Vector2D getDifference(final Vector2D a, final Vector2D b) {
        Vector2D result = new Vector2D(a);
        return result.substract(b);
    }

    public Vector2D negate() {
        x *= -1;
        y *= -1;
        return this;
    }

    @Override
    public String toString() {
        return "Vector2D{" + x + ", " + y + "}";
    }

    public double getX() {
        return x;
    }

    public void setX(final double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(final double y) {
        this.y = y;
    }
}
