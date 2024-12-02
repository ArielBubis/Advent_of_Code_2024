package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.utils;

/**
 * Solution for Day 1 of Advent of Code.
 */
public class day1 {
    public static void main(String[] args) throws Exception {
        // Read input for day 1, part A
        List<String> lines = utils.readInput(false, 1, false);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Parse input lines into left and right lists
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[1]));
        }

        // Part 1 of the puzzle
        System.out.println("Part 1: What is the total distance between your lists? " + part1(left, right));

        // Part 2 of the puzzle
        System.out.println("Part 2: What is their similarity score? " + part2(left, right));
    }

    /**
     * Calculates the total distance between two lists of integers.
     *
     * @param left  the first list of integers
     * @param right the second list of integers
     * @return the total distance between the two lists
     */
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

    /**
     * Calculates the similarity score between two lists of integers.
     *
     * @param left  the first list of integers
     * @param right the second list of integers
     * @return the similarity score between the two lists
     */
    public static Integer part2(List<Integer> left, List<Integer> right) {
        // Create a map to count occurrences of integers in the right list
        Map<Integer, Integer> rightMap = right.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));

        int similarity = 0;
        // Calculate similarity score based on occurrences in the right map
        for (int i = 0; i < left.size(); i++) {
            if (rightMap.containsKey(left.get(i))) {
                similarity += left.get(i) * rightMap.get(left.get(i));
            }
        }
        return similarity;
    }
}