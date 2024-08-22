import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromicStrings {

    public boolean canConstruct(String s, int k) {
        int oddCounts = 0;
        if (s.length() < k) {
            return false;
        }
        // Lets count characters first
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        // count having odd counts
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddCounts++;
            }
        }
        System.out.println(map);
        return oddCounts > k ? false : true;
    }

    public static void main(String[] args) {
        ConstructKPalindromicStrings obj = new ConstructKPalindromicStrings();
        String s = "annabelle";
        int k = 2;
        System.out.println(obj.canConstruct(s, k));
    }
}
