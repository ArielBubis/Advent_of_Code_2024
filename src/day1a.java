import java.util.ArrayList;
import java.util.List;

public class day1a {
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

        left.sort(Integer::compare);
        right.sort(Integer::compare);
        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            System.out.println(right.get(i) + " - " + left.get(i));
            sum += Math.abs(right.get(i) - left.get(i));

        }
        System.out.println(sum);
    }
}
