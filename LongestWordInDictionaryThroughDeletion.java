import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeletion {

    public String findLongestWord(String s, List<String> dictionary) {
        String currLongest = "";
        // lets use the two pointers and check one by one for each word against s
        for (String word : dictionary) {
            if (checkSubsequence(s, word)) {
                if (word.length() > currLongest.length()) {
                    currLongest = word;
                } else if (word.length() == currLongest.length()) {
                    // if the lengths are same check for lexicographically smaller
                    int result = currLongest.compareTo(word);
                    if (result > 0) {
                        currLongest = word;
                    }
                }
            }
        }
        return currLongest;
    }

    private boolean checkSubsequence(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                i += 1;
            }
        }
        // System.out.println(j);
        return j == target.length();
    }

    public static void main(String[] args) {
        LongestWordInDictionaryThroughDeletion obj = new LongestWordInDictionaryThroughDeletion();
        String s = "aewfafwafjlwajflwajflwafj";
        List<String> dict = new ArrayList<>(
                Arrays.asList("apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf"));
        System.out.println(obj.findLongestWord(s, dict));
    }
}
