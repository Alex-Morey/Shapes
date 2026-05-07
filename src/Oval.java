import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Represents an oval defined by two points and a color.
 *
 * @author Alexander Morey
 * @version 2.0 (Phase 2)
 */
public class Oval extends Shape {

    public Oval(Point point1, Point point2, Color color) {
        super(point1, point2, color);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(getColor());
        Point p1 = getPoint1();
        Point p2 = getPoint2();

        int x = Math.min(p1.x, p2.x);
        int y = Math.min(p1.y, p2.y);
        int w = Math.abs(p1.x - p2.x);
        int h = Math.abs(p1.y - p2.y);

        g2.drawOval(x, y, w, h);
    }
}



