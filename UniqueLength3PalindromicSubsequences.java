import java.util.HashMap;
import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences {

    public int countPalindromicSubsequence(String s) {
        HashSet<String> palindromes = new HashSet<>();
        // Lets make a left and a right hashmap
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        // for left
        left.put(s.charAt(0), 1);
        // for right
        for (int i = 2; i < s.length(); i++) {
            // maintain count in hashmap
            char curr = s.charAt(i);
            if (right.containsKey(curr)) {
                right.put(curr, right.get(curr) + 1);
            } else {
                right.put(curr, 1);
            }
        }
        // Now lets check from idx 1 to the second last index
        for (int i = 1; i + 1 < s.length(); i++) {
            // maintain count in hashmap
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            HashSet<String> pals = checkForEveryAlphabet(left, right, curr);
            palindromes.addAll(pals);
            // Now for the next part-
            // we gotta add the curr to left map
            if (left.containsKey(curr)) {
                left.put(curr, left.get(curr) + 1);
            } else {
                left.put(curr, 1);
            }
            // and we gotta remove next from right map
            if (right.get(next) == 1) {
                right.remove(next);
            } else {
                right.put(next, right.get(next) - 1);
            }
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(palindromes);
        return palindromes.size();
    }

    private HashSet<String> checkForEveryAlphabet(HashMap<Character, Integer> a, HashMap<Character, Integer> b,
            char mid) {
        HashSet<String> pals = new HashSet<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            StringBuilder str = new StringBuilder();
            if (a.containsKey(ch) && b.containsKey(ch)) {
                str.append(ch);
                str.append(mid);
                str.append(ch);
                pals.add(str.toString());
            }
        }
        return pals;
    }

    public static void main(String[] args) {
        UniqueLength3PalindromicSubsequences obj = new UniqueLength3PalindromicSubsequences();
        String s = "aabca";
        System.out.println(obj.countPalindromicSubsequence(s));
    }
}