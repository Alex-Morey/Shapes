import java.awt.Point;

/**
 * Abstract base class for all shapes.
 */
public abstract class Shape {
    private Point point1;
    private Point point2;
    private double color;

    public Shape(Point point1, Point point2, double color) {
        if (point1 == null || point2 == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }
        this.point1 = point1;
        this.point2 = point2;
        this.color = color;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public double getColor() {
        return color;
    }

    /** Prints the shape */
    public abstract void draw();
}


