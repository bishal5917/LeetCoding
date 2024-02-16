import java.util.HashMap;
import java.util.Map;

public class ShortEncodingOfWords {

    public int minimumLengthEncoding(String[] words) {
        // Using our suffix tree data structure
        Trie trie = new Trie();
        for (String word : words) {
            // Insert from end makes a suffix tree
            trie.insertFromEnd(word);
        }
        // Now we gotta traverse by DFS till we reach the end of the root
        HashMap<Character, TrieNode> childs = trie.getRoot().getChildren();
        StringBuilder ans = getMinimumEncodingHelper(childs, new StringBuilder(), new StringBuilder(), false);
        System.out.println(ans);
        return ans.length();
    }

    private StringBuilder getMinimumEncodingHelper(HashMap<Character, TrieNode> all, StringBuilder curr,
            StringBuilder ans,
            boolean isEndOfString) {
        if (all.isEmpty() && isEndOfString == true) {
            // means no child and is the end of the string so add to ans and add #
            ans.append(curr);
            ans.append("#");
            return ans;
        }
        for (Map.Entry<Character, TrieNode> entry : all.entrySet()) {
            // Keep adding to the current
            curr.append(entry.getKey());
            // go for another one recursively
            ans = getMinimumEncodingHelper(all.get(entry.getKey()).getChildren(), curr, ans,
                    all.get(entry.getKey()).isEndOfTheWord());
            // Start backtracking while stack starts to unwind to reach another possibility
            curr.deleteCharAt(curr.length() - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = { "time", "me", "bell" };
        ShortEncodingOfWords obj = new ShortEncodingOfWords();
        int ans = obj.minimumLengthEncoding(words);
        System.out.println(ans);
    }

}
