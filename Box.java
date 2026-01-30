/**
 * 2217 Java Software Dev 2
 * Project 1 - Shapes, Phase 1
 *
 * Represents a box (rectangle) shape defined by two points and a color.
 *
 * author Chad
 * @version 1.0
 */

import java.awt.Point;

/**
 * Represents a box (rectangle) defined by two points and a color.
 */
public class Box extends Shape {

    /**
     * Constructs a Box with two points and a color.
     *
     * @param point1 first point
     * @param point2 second point
     * @param color  color value
     */
    public Box(Point point1, Point point2, double color) {
        super(point1, point2, color);
    }

    /** Draws the box (Phase 1: intentionally empty). */
    public void draw() {
        System.out.print("Box");
    }
}

