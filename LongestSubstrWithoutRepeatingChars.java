import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int currLongest = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                // remove from the set and move i forward (SLIDING THE WINDOW)
                set.remove(s.charAt(i));
                i += 1;
            } else {
                set.add(s.charAt(j));
                // track the distance
                currLongest = Math.max(currLongest, j - i + 1);
                j += 1;
            }
        }
        return currLongest;
    }

    public static void main(String[] args) {
        LongestSubstrWithoutRepeatingChars obj = new LongestSubstrWithoutRepeatingChars();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
