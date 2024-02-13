import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        Trie trie = new Trie();
        for (int i = 1; i <= n; i++) {
            trie.insert(Integer.toString(i));
        }
        // System.out.println(trie.getRoot().getChildren());
        return sortLexicallyRecursiveHelper(trie.getRoot().getChildren(), '-', new StringBuilder(), false,
                new ArrayList<>());
    }

    // Just traversing
    List<Integer> sortLexicallyRecursiveHelper(HashMap<Character, TrieNode> childs, Character key,
            StringBuilder curr, boolean isEndOfString, List<Integer> numbers) {
        if (isEndOfString == true) {
            // If we found end of the string,just add
            numbers.add(Integer.valueOf(curr.toString()));
        }
        if (childs.isEmpty()) {
            // If we went through all the childs,just return
            return numbers;
        }
        // go for folders entrysets for that key
        for (Map.Entry<Character, TrieNode> entry : childs.entrySet()) {
            // Keep adding to the current
            curr.append(entry.getKey());
            // go for another one recursively
            numbers = sortLexicallyRecursiveHelper(childs.get(entry.getKey()).getChildren(), entry.getKey(), curr,
                    childs.get(entry.getKey()).isEndOfTheWord(), numbers);
            // Start backtracking while stack starts to unwind to reach another possibility
            curr.deleteCharAt(curr.length() - 1);
        }
        return numbers;
    }

    public static void main(String[] args) {
        LexicographicalNumbers obj = new LexicographicalNumbers();
        List<Integer> ans = obj.lexicalOrder(120);
        System.out.println(ans);
    }
}