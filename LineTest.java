import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LineTest {

    public static void main(String[] args) {
        Line line = new Line(new Point(0, 0), new Point(1, 1), 1.0);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        line.draw();

        System.setOut(original);

        String result = out.toString().trim();

        if (result.equals("Line")) {
            System.out.println("LineTest PASSED");
        } else {
            System.out.println("LineTest FAILED");
            System.out.println("Expected: Line");
            System.out.println("Actual: " + result);
        }
    }
}



