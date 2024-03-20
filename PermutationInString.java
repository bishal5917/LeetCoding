import java.util.HashMap;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();
        int i = 0;
        int j = 0;
        // Take the count of the target
        while (j < s1.length()) {
            char curr = s1.charAt(j);
            if (s1Map.get(curr) == null) {
                s1Map.put(curr, 1);
            } else {
                s1Map.put(curr, s1Map.get(curr) + 1);
            }
            j += 1;
        }
        // maintain a first window,take the count
        // Take the count of the target
        while (i < j) {
            char curr = s2.charAt(i);
            if (s2Map.get(curr) == null) {
                s2Map.put(curr, 1);
            } else {
                s2Map.put(curr, s2Map.get(curr) + 1);
            }
            i += 1;
        }
        // take back i to the first
        i = 0;
        if (s1Map.equals(s2Map)) {
            return true;
        }
        // NOW LETS SLIDE THE WINDOW
        while (j < s2.length()) {
            char prevChar = s2.charAt(i);
            char nextChar = s2.charAt(j);
            // remove the previous
            if (s2Map.get(prevChar) == 1) {
                s2Map.remove(prevChar);
            } else {
                s2Map.put(prevChar, s2Map.get(prevChar) - 1);
            }
            // add the new one
            if (s2Map.get(nextChar) == null) {
                s2Map.put(nextChar, 1);
            } else {
                s2Map.put(nextChar, s2Map.get(nextChar) + 1);
            }
            if (s1Map.equals(s2Map)) {
                // if its equal or permutation,return true
                System.out.println(s2Map);
                System.out.println(s1Map);
                return true;
            }
            i += 1;
            j += 1;
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(obj.checkInclusion(s1, s2));
    }
}
