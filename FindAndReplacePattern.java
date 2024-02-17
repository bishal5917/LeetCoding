import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        // go for every words
        for (String word : words) {
            if (checkIsSamePattern(word, pattern)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean checkIsSamePattern(String word, String pattern) {
        HashMap<Character, Character> wordToPatternMap = new HashMap<>();
        HashMap<Character, Character> patternToWordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (wordToPatternMap.get(word.charAt(i)) == null) {
                if (patternToWordMap.get(pattern.charAt(i)) != null) {
                    // But if the pattern has a match already return false
                    return false;
                }
                // means no mapped
                // just map to both
                wordToPatternMap.put(word.charAt(i), pattern.charAt(i));
                patternToWordMap.put(pattern.charAt(i), word.charAt(i));
            } else {
                // just checking there must be a one to one unique mapping
                if (wordToPatternMap.get(word.charAt(i)) != pattern.charAt(i)) {
                    return false;
                }
                if (patternToWordMap.get(pattern.charAt(i)) != word.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
        String pattern = "abb";
        FindAndReplacePattern obj = new FindAndReplacePattern();
        List<String> ans = obj.findAndReplacePattern(words, pattern);
        System.out.println(ans);
    }

}
