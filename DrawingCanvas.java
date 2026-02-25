import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class DrawingCanvas extends JComponent {

    private final LinkedList<Shape> shapes = new LinkedList<>();

    private ShapeType currentShapeType = ShapeType.LINE; // choose your default
    private Color currentColor = Color.BLACK;            // choose your default
    private boolean trailsOn = false;

    private Point pressPoint = null; // initial mouse press point

    public DrawingCanvas() {
        setFocusable(true);

        // Mouse handling (MouseAdapter covers MouseListener + MouseMotionListener)
        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
                pressPoint = e.getPoint();

                Shape s = makeShape(pressPoint, pressPoint, currentColor, currentShapeType);
                shapes.add(s);
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (pressPoint == null || shapes.isEmpty()) return;

                Point current = e.getPoint();

                if (!trailsOn) {
                    // Rubber band: update the end point of the last shape
                    shapes.getLast().setPoint2(current);
                } else {
                    // Trails: create a new shape for each drag event
                    Shape s = makeShape(pressPoint, current, currentColor, currentShapeType);
                    shapes.add(s);
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressPoint = null;
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);

        // Key handling
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = Character.toUpperCase(e.getKeyChar());

                switch (ch) {
                    case 'E' -> { // erase
                        shapes.clear();
                        repaint();
                    }
                    case 'T' -> { // toggle trails
                        trailsOn = !trailsOn;
                        repaint();
                    }
                    case 'L' -> currentShapeType = ShapeType.LINE;
                    case 'B' -> currentShapeType = ShapeType.BOX;
                    case 'O' -> currentShapeType = ShapeType.OVAL;
                    case 'C' -> {
                        Color selected = javax.swing.JColorChooser.showDialog(
                                SwingUtilities.getWindowAncestor(DrawingCanvas.this),
                                "Choose a Color",
                                currentColor
                        );
                        if (selected != null) {
                            currentColor = selected;
                        }
                    }
                    default -> {
                        // ignore other keys
                    }
                }
            }
        });
    }

    private Shape makeShape(Point p1, Point p2, Color color, ShapeType type) {
        return switch (type) {
            case LINE -> new Line(p1, p2, color);
            case BOX  -> new Box(p1, p2, color);
            case OVAL -> new Oval(p1, p2, color);
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Shape s : shapes) {
            s.draw(g2);
        }

        g2.dispose();
    }
}
