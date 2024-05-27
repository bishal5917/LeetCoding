
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxScoreWordsFormedByLetters {

    int maxScore = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // Lets count letters
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : letters) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        dfsHelper(words, map, score, new ArrayList<>(), 0);
        return maxScore;
    }

    private List<String> dfsHelper(String[] words, HashMap<Character, Integer> map, int[] score, List<String> curr,
            int idx) {
        // System.out.println(curr);
        // calculate the score and update
        maxScore = Math.max(maxScore, getScore(curr, score));
        for (int i = idx; i < words.length; i++) {
            // get the current word
            String currWord = words[i];
            // Before adding gotta check if all the words contains in map
            if (!canUseLetters(currWord, map)) {
                continue;
            }
            // add to the array,consider it
            curr.add(currWord);
            // decrement count
            for (char c : currWord.toCharArray()) {
                map.put(c, map.get(c) - 1);
            }
            curr = dfsHelper(words, map, score, curr, i + 1);
            // backtrack
            // deconsider,remove from set
            curr.remove(curr.size() - 1);
            // re-increment the count
            for (char c : currWord.toCharArray()) {
                map.put(c, map.get(c) + 1);
            }
        }
        return curr;
    }

    private boolean canUseLetters(String word, HashMap<Character, Integer> map) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        // Now check if can use
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            if (map.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private int getScore(List<String> words, int[] score) {
        int total = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                total += score[c - 97];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        MaxScoreWordsFormedByLetters obj = new MaxScoreWordsFormedByLetters();
        String[] words = { "dog", "cat", "dad", "good" };
        char[] letters = { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
        int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        System.out.println(obj.maxScoreWords(words, letters, score));
    }
}
