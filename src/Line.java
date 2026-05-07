import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Represents a line defined by two points and a color.
 *
 * @author Alexander Morey
 * @version 2.0 (Phase 2)
 */
public class Line extends Shape {

    public Line(Point point1, Point point2, Color color) {
        super(point1, point2, color);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        Point p1 = getPoint1();
        Point p2 = getPoint2();
        g2.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}


