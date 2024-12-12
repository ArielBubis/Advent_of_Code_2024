package solutions;

import java.util.regex.Pattern;
import java.util.List;
import java.util.regex.Matcher;

import utils.utils;

public class day3 {
    public static void main(String[] args) throws Exception {
        List<String> lines = utils.readInput(false, 3, false);

        part1(lines);
        part2(lines);
    }

    private static void part1(List<String> lines) {
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        int mul = 0;
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                mul += num1 * num2;
            }
        }
        System.out.println(mul);
    }

    private static void part2(List<String> lines) {
        Pattern pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)");
        boolean isEnabled = true;
        int mul = 0;
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group();
                if (match.equals("do()")) {
                    isEnabled = true;
                } else if (match.equals("don't()")) {
                    isEnabled = false;
                } else if (match.startsWith("mul(") && isEnabled) {
                    int num1 = Integer.parseInt(matcher.group(1));
                    int num2 = Integer.parseInt(matcher.group(2));
                    mul += num1 * num2;
                }
            }
        }

        // Output the final result
        System.out.println(mul);
    }

}
