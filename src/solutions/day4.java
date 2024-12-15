package solutions;

import java.util.ArrayList;
import java.util.List;

import utils.utils;

public class day4 {
    public static void main(String[] args) throws Exception {
        List<String> lines = utils.readInput(false, 4, false);
        char[][] matrix = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }

        part1(matrix);
        part2(matrix);
    }

    private static void part1(char[][] matrix) {
        String word = "XMAS";
        int count = 0;
        // Generate all directions using nested loops
        List<int[]> directions = new ArrayList<>();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    directions.add(new int[] { dx, dy });
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int[] dir : directions) {
                    if (hasXMAS(matrix, word, i, j, dir[0], dir[1])) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static boolean hasXMAS(char[][] matrix, String word, int i, int j, int dx, int dy) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Iterate over the word and check if it matches the pattern in the matrix
        for (int k = 0; k < word.length(); k++) {
            // Calculate the new coordinates
            int ii = i + k * dx;
            int jj = j + k * dy;

            // Check bounds
            if (ii < 0 || ii >= n || jj < 0 || jj >= m) {
                return false;
            }

            // Check character match
            if (matrix[ii][jj] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private static void part2(char[][] matrix) {
        int ans = 0;

        // Iterate over every cell in the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hasXMAS(matrix, i, j, matrix.length, matrix[0].length)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean hasXMAS(char[][] matrix, int i, int j, int n, int m) {
        // Check if the cell is within the valid range
        if (!(1 <= i && i < n - 1 && 1 <= j && j < m - 1)) {
            return false;
        }

        // Check if the current cell contains 'A' to start checking the sorrounding
        // cells for the pattern
        if (matrix[i][j] != 'A') {
            return false;
        }

        // Check both diagonals
        String diag1 = "" + matrix[i - 1][j - 1] + matrix[i + 1][j + 1];
        String diag2 = "" + matrix[i - 1][j + 1] + matrix[i + 1][j - 1];

        // Return true if either diagonal matches the required patterns
        return (diag1.equals("MS") || diag1.equals("SM")) && (diag2.equals("MS") || diag2.equals("SM"));
    }
}
