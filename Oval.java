/**
 * 2217 Java Software Dev 2
 * Project 1 - Shapes, Phase 1
 *
 * Represents an oval shape defined by two points and a color.
 *
 * @author Chad
 * @version 1.0
 */

import java.awt.Point;

/**
 * Represents an oval defined by two points and a color.
 */
public class Oval extends Shape {

    /**
     * Constructs an Oval with two points and a color.
     *
     * @param point1 first point
     * @param point2 second point
     * @param color  color value
     */
    public Oval(Point point1, Point point2, double color) {
        super(point1, point2, color);
    }

    public void draw() {
        System.out.print("Oval");
    }
}

