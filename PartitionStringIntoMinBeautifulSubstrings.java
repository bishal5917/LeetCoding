import java.util.ArrayList;
import java.util.List;

public class PartitionStringIntoMinBeautifulSubstrings {

    int minSize = Integer.MAX_VALUE;

    public int minimumBeautifulSubstrings(String s) {
        partitionStringHelper(s, new ArrayList<>(), 0);
        return minSize == Integer.MAX_VALUE ? -1 : minSize;
    }

    private List<String> partitionStringHelper(String s, List<String> curr, int st) {
        if (st >= s.length()) {
            System.out.println(curr);
            // check if its a power of five
            if (checkPowerOfFiveHelper(curr)) {
                // if all are powers of five update the value
                minSize = Math.min(minSize, curr.size());
            }
            return curr;
        }
        // Now time to generate every substrings
        for (int i = 1; i <= s.length(); i++) {
            if (st + i > s.length()) {
                continue;
            }
            String split = s.substring(st, st + i);
            if (split.startsWith("0")) {
                continue;
            }
            curr.add(split);
            curr = partitionStringHelper(s, curr, st + i);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private boolean checkPowerOfFiveHelper(List<String> arr) {
        for (String str : arr) {
            if (!isPowerOfFive(str)) {
                return false;
            }
        }
        return true;
    }

    // check if all strings are power of 5
    private boolean isPowerOfFive(String binaryString) {
        // Converting binary string to decimal
        int number = Integer.parseInt(binaryString, 2);

        // 1 is always power of five,return true
        if (number == 1) {
            return true;
        }

        // Checking if number is a power of 5
        while (number > 1) {
            if (number % 5 != 0) {
                return false;
            }
            number /= 5;
        }

        return number == 1;
    }

    public static void main(String[] args) {
        PartitionStringIntoMinBeautifulSubstrings obj = new PartitionStringIntoMinBeautifulSubstrings();
        String s = "1011";
        System.out.println(obj.minimumBeautifulSubstrings(s));
    }
}
