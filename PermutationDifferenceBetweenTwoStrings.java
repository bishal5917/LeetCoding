import java.util.HashMap;
import java.util.Map;

public class PermutationDifferenceBetweenTwoStrings {

    public int findPermutationDifference(String s, String t) {
        int totalDiff = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            int diff = map.get(curr) - i;
            map.put(curr, Math.abs(diff));
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            totalDiff += entry.getValue();
        }
        return totalDiff;
    }

    public static void main(String[] args) {
        PermutationDifferenceBetweenTwoStrings obj = new PermutationDifferenceBetweenTwoStrings();
        String s = "abcde";
        String t = "edbac";
        System.out.println(obj.findPermutationDifference(s, t));
    }

}
