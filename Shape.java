import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Abstract base class for all shapes.
 * A shape is defined by two points and a color.
 *
 * @author Alexander Morey
 * @version 2.0 (Phase 2)
 */
public abstract class Shape {
    private Point point1;
    private Point point2;
    private Color color;

    public Shape(Point point1, Point point2, Color color) {
        if (point1 == null || point2 == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }
        this.point1 = new Point(point1);
        this.point2 = new Point(point2);
        this.color = (color == null) ? Color.BLACK : color;
    }

    public Point getPoint1() {
        return new Point(point1);
    }

    public Point getPoint2() {
        return new Point(point2);
    }

    public void setPoint2(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Point cannot be null");
        }
        this.point2 = new Point(p);
    }

    public Color getColor() {
        return color;
    }

    /** Draws the shape onto the canvas. */
    public abstract void draw(Graphics2D g2);
}




