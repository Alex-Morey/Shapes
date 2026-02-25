import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SimpleDrawingFrame extends JFrame {

    public SimpleDrawingFrame() {
        super("Simple Drawing");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DrawingCanvas canvas = new DrawingCanvas();
        add(canvas, BorderLayout.CENTER);

        JLabel help = new JLabel("(E)rase (T)rails (L)ine (B)ox (O)val (C)olor", SwingConstants.CENTER);
        add(help, BorderLayout.SOUTH);

        setSize(700, 800);
        setLocationRelativeTo(null);

        // Make sure keys go to the canvas
        canvas.requestFocusInWindow();
    }
}
