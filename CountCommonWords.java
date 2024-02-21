import java.util.HashMap;
import java.util.Map;

public class CountCommonWords {

    public int countWords(String[] words1, String[] words2) {
        int count = 0;
        HashMap<String, Integer> word1Map = new HashMap<>();
        HashMap<String, Integer> word2Map = new HashMap<>();
        // add words to hashset with some logic
        for (String word : words1) {
            if (word1Map.get(word) == null) {
                word1Map.put(word, 1);
            } else {
                word1Map.put(word, word1Map.get(word) + 1);
            }
        }
        for (String word : words2) {
            if (word2Map.get(word) == null) {
                word2Map.put(word, 1);
            } else {
                word2Map.put(word, word2Map.get(word) + 1);
            }
        }
        // Now check for every entries in map1
        for (Map.Entry<String, Integer> entry : word1Map.entrySet()) {
            if (entry.getValue() == 1) {
                // means if its unique in 1
                if (word2Map.get(entry.getKey()) != null && word2Map.get(entry.getKey()) == 1) {
                    // it must also be unique in 2
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountCommonWords obj = new CountCommonWords();
        String[] words1 = { "leetcode", "is", "amazing", "as", "is" };
        String[] words2 = { "amazing", "leetcode", "is" };
        System.out.println(obj.countWords(words1, words2));
    }

}
