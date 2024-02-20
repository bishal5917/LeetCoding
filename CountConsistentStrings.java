import java.util.HashSet;

public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        // Lets create a hashset that contains each unique characters in allowed
        HashSet<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;
        // Now iterate over all the words and check if its consistent
        for (String word : words) {
            if (isWordConsistent(word, allowedSet)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean isWordConsistent(String word, HashSet<Character> allowed) {
        for (char c : word.toCharArray()) {
            if (!allowed.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = { "ad", "bd", "aaab", "baa", "badab" };
        CountConsistentStrings obj = new CountConsistentStrings();
        System.out.println(obj.countConsistentStrings(allowed, words));
    }

}
