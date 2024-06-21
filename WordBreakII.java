import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // Lets add these words in a hashset first
        List<String> ans = new ArrayList<>();
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        dfsHelper(s, 0, new ArrayList<>(), wordSet, ans);
        return ans;
    }

    private List<String> dfsHelper(String s, int idx, List<String> curr, HashSet<String> set, List<String> ans) {
        if (idx >= s.length()) {
            // if we went out of bounds,then all are found
            System.out.println(curr);
            // add to the answer
            ans.add(String.join(" ", curr));
        }
        for (int i = idx; i < s.length(); i++) {
            String word = s.substring(idx, i + 1);
            if (!set.contains(word)) {
                continue;
            }
            curr.add(word);
            curr = dfsHelper(s, i + 1, curr, set, ans);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    public static void main(String[] args) {
        WordBreakII obj = new WordBreakII();
        String s = "catsanddog";
        List<String> words = new ArrayList<>(
                Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(obj.wordBreak(s, words));
    }
}
