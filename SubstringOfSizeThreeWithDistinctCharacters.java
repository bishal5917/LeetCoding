import java.util.HashMap;

public class SubstringOfSizeThreeWithDistinctCharacters {

    public int countGoodSubstrings(String s) {
        // Lets maintain a fixed window of size 3
        int count = 0;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // Lets maintain a first window
        while (j < 3 && j < s.length()) {
            char curr = s.charAt(j);
            if (map.get(curr) == null) {
                map.put(curr, 1);
            } else {
                map.put(curr, map.get(curr) + 1);
            }
            j += 1;
        }
        if (map.size() == 3) {
            count += 1;
        }
        // NOW LETS SLIDE THE WINDOW
        while (j < s.length()) {
            char prev = s.charAt(i);
            char next = s.charAt(j);
            // remove the prev
            if (map.get(prev) == 1) {
                map.remove(prev);
            } else {
                map.put(prev, map.get(prev) - 1);
            }
            // add the next one
            if (map.get(next) == null) {
                map.put(next, 1);
            } else {
                map.put(next, map.get(next) + 1);
            }
            // increment the count if valid
            if (map.size() == 3)
                count += 1;
            i += 1;
            j += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubstringOfSizeThreeWithDistinctCharacters obj = new SubstringOfSizeThreeWithDistinctCharacters();
        String s = "aababcabc";
        System.out.println(obj.countGoodSubstrings(s));
    }
}