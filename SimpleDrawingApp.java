import javax.swing.SwingUtilities;

public class SimpleDrawingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleDrawingFrame frame = new SimpleDrawingFrame();
            frame.setVisible(true);
        });
    }
}

