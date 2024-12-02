import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class utils {
    public static List<String> readInput(boolean test, int day, boolean partb) throws IOException {
        String testdir = "";
        if (test) {
            testdir = (partb) ? "test_b" : "test_a";
        } else {
            testdir = (partb) ? "input_b" : "input_a";
        }
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(testdir + "/day" + day + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}
