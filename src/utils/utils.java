package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;

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
        Path filePath = Paths.get("src", "resources", testdir, "day" + day + ".txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }
}
