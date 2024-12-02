package utils;
import java.io.BufferedReader;
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
        ///Advent_of_Code_2024/Advent_of_Code_2024/src/resources/input_a/day1.txt
        try (BufferedReader reader = new BufferedReader(new FileReader("Advent_of_Code_2024/src/resources/" + testdir + "/day" + day + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}
