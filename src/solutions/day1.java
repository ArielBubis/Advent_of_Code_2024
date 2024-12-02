package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.utils;

public class day1 {
    public static void main(String[] args) throws Exception {
        List<String> lines = utils.readInput(false, 1, false);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split("\\s+");
            // System.out.println(Arrays.toString(parts));

            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));

        }

        // Part 1 of the puzzle
        System.out.println("Part 1: What is the total distance between your lists? " + part1(left, right));

        System.out.println("Part 2: What is their similarity score? " + part2(left, right));

    }

    public static Integer part1(List<Integer> left, List<Integer> right) {
        left.sort(Integer::compare);
        right.sort(Integer::compare);
        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            System.out.println(right.get(i) + " - " + left.get(i));
            sum += Math.abs(right.get(i) - left.get(i));

        }
        return sum;
    }

    public static Integer part2(List<Integer> left, List<Integer> right) {
        HashMap<Integer, Integer> rightMap = new HashMap<>();

        for (int i = 0; i < right.size(); i++) {
            if (rightMap.containsKey(right.get(i))) {
                rightMap.put(right.get(i), rightMap.get(right.get(i)) + 1);
            } else {
                rightMap.put(right.get(i), 1);
            }
        }

        int similarity = 0;
        for (int i = 0; i < left.size(); i++) {
            if (rightMap.containsKey(left.get(i))) {
                similarity += left.get(i) * rightMap.get(left.get(i));
            }
        }
        return similarity;
    }
}
