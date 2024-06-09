import java.util.HashMap;

public class MaxLengthSubstringWithTwoOccurences {

    public int maximumLengthSubstring(String s) {
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char curr = s.charAt(r);
            // put the value in map
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            } else {
                map.put(curr, map.get(curr) + 1);
            }
            // shrink,slide from left
            while (map.get(curr) > 2) {
                char leftChar = s.charAt(l);
                int dec = map.get(leftChar) - 1;
                if (dec == 0) {
                    map.remove(leftChar);
                } else {
                    map.put(leftChar, dec);
                }
                l += 1;
            }
            // track the length
            len = Math.max(len, r - l + 1);
            r += 1;
        }
        return len;
    }

    public static void main(String[] args) {
        MaxLengthSubstringWithTwoOccurences obj = new MaxLengthSubstringWithTwoOccurences();
        String s = "bcbbbcba";
        System.out.println(obj.maximumLengthSubstring(s));
    }
}
