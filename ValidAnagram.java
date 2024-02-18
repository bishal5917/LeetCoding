import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> bucketFors = new HashMap<>();
        HashMap<Character, Integer> bucketFort = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (bucketFors.get(c) == null) {
                bucketFors.put(c, 1);
            } else {
                int newCount = bucketFors.get(c) + 1;
                bucketFors.put(c, newCount);
            }
        }

        // now check for t
        for (char c : t.toCharArray()) {
            if (bucketFort.get(c) == null) {
                bucketFort.put(c, 1);
            } else {
                int newCount = bucketFort.get(c) + 1;
                bucketFort.put(c, newCount);
            }
        }

        // Now check if two hashmaps are equal or not
        for (Map.Entry<Character, Integer> entry : bucketFors.entrySet()) {
            if (!entry.getValue().equals(bucketFort.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        boolean ans = obj.isAnagram(s, t);
        System.out.println(ans);
    }

}
