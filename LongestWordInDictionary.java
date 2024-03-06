import java.util.HashSet;

public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        // for every word,lets check if the prefix is in our set
        String longest = "";
        HashSet<String> prefixes = new HashSet<>();
        for (String word : words) {
            prefixes.add(word);
        }
        // Now lets check each and every words
        for (String word : words) {
            if (hasAllPrefixes(prefixes, word)) {
                // if it has all the prefixes
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length()) {
                    // if the lengths are same check for lexicographically smaller
                    int result = longest.compareTo(word);
                    if (result > 0) {
                        longest = word;
                    }
                }
            }
        }
        return longest;
    }

    private boolean hasAllPrefixes(HashSet<String> prefixes, String word) {
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            curr.append(word.charAt(i));
            if (!prefixes.contains(curr.toString())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestWordInDictionary obj = new LongestWordInDictionary();
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(obj.longestWord(words));
    }
}
