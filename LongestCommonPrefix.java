import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // Using the trie data structure
        Trie trie = new Trie();
        // Insert words to our trie
        for (String word : strs) {
            if (!word.isEmpty()) {
                trie.insert(word);
            } else {
                // Even if the word is empty,insert some character
                // We will handle this later
                trie.insert("*");
            }
        }
        // Track the longest one
        StringBuilder longest = new StringBuilder();
        // Get the root of our trie
        TrieNode root = trie.getRoot();

        // BASICALLY DOING FOR EVERY CHILDREN OF THE ROOT
        for (Map.Entry<Character, TrieNode> entry : root.getChildren().entrySet()) {
            // tracking the current common prefix
            StringBuilder currPrefix = new StringBuilder();
            Character key = entry.getKey();
            if (longest.length() > 0 && longest.charAt(0) != key) {
                // Directly return if the current key wont match with previous first string
                return "";
            }
            // add the key to the currPrefix
            currPrefix.append(key);
            // If the key was the end of the word,check if its longest or not and continue
            if (root.getChildren().get(key).isEndOfTheWord() == true) {
                if (currPrefix.length() > longest.length()) {
                    longest = currPrefix;
                }
                continue;
            }
            // for keys of the child
            HashMap<Character, TrieNode> child = root.getChildren().get(key).getChildren();
            // Basically keep tracking of the key,until we reach the end of the word
            // or until we reach a key with more than one children
            while (child.entrySet().size() == 1) {
                Character currKey = child.entrySet().iterator().next().getKey();
                currPrefix.append(currKey);
                // If we reach the end of word , just break out of while loop
                if (child.get(currKey).isEndOfTheWord() == true) {
                    break;
                }
                child = child.get(currKey).getChildren();
            }
            // track the longest string before we move to next child character of root
            if (currPrefix.length() > longest.length()) {
                longest = currPrefix;
            }
        }
        // Handling for empty words we added earlier
        // if we have * just return empty string else return the longest one
        return longest.toString().equals("*") ? "" : longest.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String[] strs = { "flower", "flow", "flight" };
        String ans = obj.longestCommonPrefix(strs);
        System.out.println(ans);
    }
}