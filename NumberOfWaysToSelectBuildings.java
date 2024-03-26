import java.util.HashMap;

public class NumberOfWaysToSelectBuildings {

    public long numberOfWays(String s) {
        long ways = 0;
        // Lets maintain a count for left and right map
        HashMap<Character, Long> left = new HashMap<>();
        HashMap<Character, Long> right = new HashMap<>();
        left.put(s.charAt(0), 1l);
        // for right
        for (int i = 2; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (right.containsKey(curr)) {
                right.put(curr, right.get(curr) + 1);
            } else {
                right.put(curr, 1l);
            }
        }
        // Lets go and count alternates to the left and right
        for (int i = 1; i + 1 < s.length(); i++) {
            System.out.println(left + " -- " + right);
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if (curr == '1') {
                // get zeroes to the left and right
                if (left.get('0') != null && right.get('0') != null) {
                    ways += left.get('0') * right.get('0');
                }
            } else {
                // get ones to the left and right
                if (left.get('1') != null && right.get('1') != null) {
                    ways += left.get('1') * right.get('1');
                }
            }
            // NOW FOR NEXT ITERATION
            // Add current to the left
            if (left.containsKey(curr)) {
                left.put(curr, left.get(curr) + 1);
            } else {
                left.put(curr, 1l);
            }
            // remove next from the right
            if (right.get(next) == 1) {
                right.remove(next);
            } else {
                right.put(next, right.get(next) - 1);
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        NumberOfWaysToSelectBuildings obj = new NumberOfWaysToSelectBuildings();
        String s = "0001100100";
        System.out.println(obj.numberOfWays(s));
    }
}
