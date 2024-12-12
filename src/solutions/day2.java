package solutions;

import java.util.List;

import utils.utils;

public class day2 {
    public static void main(String[] args) throws Exception {
        List<String> lines = utils.readInput(false, 2, false);

        part1(lines);
        part2(lines);

    }

    private static void part1(List<String> lines) {
        int validCount = 0;
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            boolean isValid = true;
            boolean isIncreasing = Integer.parseInt(parts[1]) > Integer.parseInt(parts[0]);

            for (int i = 1; i < parts.length; i++) {
                int current = Integer.parseInt(parts[i]);
                int previous = Integer.parseInt(parts[i - 1]);
                int diff = current - previous;

                if (isIncreasing) {
                    if (diff < 1 || diff > 3) {
                        isValid = false;
                        break;
                    }
                } else {
                    if (diff > -1 || diff < -3) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                validCount++;
            }
        }
        System.out.println(validCount);
    }

    private static void part2(List<String> lines) {
        int validCount = 0;
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            int[] numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i]);
            }

            // Check if the sequence is already safe
            if (isSafeSequence(numbers)) {
                validCount++;
                continue;
            }

            // Try removing each number to see if it becomes safe
            boolean foundSafeRemoval = false;
            for (int removeIndex = 0; removeIndex < numbers.length; removeIndex++) {
                int[] reducedSequence = new int[numbers.length - 1];

                // Create a new sequence without the current index
                for (int i = 0, j = 0; i < numbers.length; i++) {
                    if (i != removeIndex) {
                        reducedSequence[j++] = numbers[i];
                    }
                }

                // Check if reduced sequence is safe
                if (isSafeSequence(reducedSequence)) {
                    foundSafeRemoval = true;
                    break;
                }
            }

            if (foundSafeRemoval) {
                validCount++;
            }
        }
        System.out.println(validCount);
    }

    private static boolean isSafeSequence(int[] sequence) {
        if (sequence.length <= 1)
            return true;

        boolean isIncreasing = sequence[1] > sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            int current = sequence[i];
            int previous = sequence[i - 1];
            int diff = current - previous;

            if (isIncreasing) {
                if (diff < 1 || diff > 3) {
                    return false;
                }
            } else {
                if (diff > -1 || diff < -3) {
                    return false;
                }
            }
        }
        return true;
    }
}
