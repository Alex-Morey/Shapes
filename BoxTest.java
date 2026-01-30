import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoxTest {

    public static void main(String[] args) {
        Box box = new Box(new Point(0, 0), new Point(1, 1), 1.0);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        box.draw();

        System.setOut(original);

        String result = out.toString().trim();

        if (result.equals("Box")) {
            System.out.println("BoxTest PASSED");
        } else {
            System.out.println("BoxTest FAILED");
            System.out.println("Expected: Box");
            System.out.println("Actual: " + result);
        }
    }
}

    


