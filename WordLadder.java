import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Lets put words in a hashset
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        return bfsHelper(beginWord, endWord, wordSet);
    }

    private int bfsHelper(String s, String e, HashSet<String> set) {
        int len = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            len++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (visited.contains(word)) {
                    continue;
                }
                if (word.equals(e)) {
                    return len;
                }
                visited.add(word);
                for (int idx = 0; idx < word.length(); idx++) {
                    char[] wordChar = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChar[idx] = c;
                        String str = new String(wordChar);
                        if (!visited.contains(str) && set.contains(str)) {
                            q.offer(str);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> words = new ArrayList<>(
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(obj.ladderLength(beginWord, endWord, words));
    }
}
