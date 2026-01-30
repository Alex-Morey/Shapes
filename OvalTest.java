import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OvalTest {

    public static void main(String[] args) {
        Oval oval = new Oval(new Point(0, 0), new Point(1, 1), 1.0);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        oval.draw();

        System.setOut(original);

        String result = out.toString().trim();

        if (result.equals("Oval")) {
            System.out.println("OvalTest PASSED");
        } else {
            System.out.println("OvalTest FAILED");
            System.out.println("Expected: Oval");
            System.out.println("Actual: " + result);
        }
    }
}



