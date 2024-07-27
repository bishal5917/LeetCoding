import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SequentialDigits {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> digits = new ArrayList<>();
        HashSet<String> used = new HashSet<>();
        String digit = "123456789";
        // Now lets do this using sliding window
        int i = 0;
        int j = 1;
        while (j <= digit.length()) {
            String curr = digit.substring(i, j);
            if (Integer.valueOf(curr) <= high) {
                for (int idx = 0; idx < curr.length(); idx++) {
                    String num = curr.substring(idx, curr.length());
                    if (Integer.valueOf(num) >= low) {
                        if (!used.contains(num)) {
                            digits.add(Integer.valueOf(num));
                            used.add(num);
                        }
                    }
                }
            } else {
                // else we reset that
                i += 1;
                j = i + 1;
            }
            j += 1;
        }
        Collections.sort(digits);
        return digits;
    }

    public static void main(String[] args) {
        SequentialDigits obj = new SequentialDigits();
        int low = 1000;
        int high = 13000;
        System.out.println(obj.sequentialDigits(low, high));
    }
}
