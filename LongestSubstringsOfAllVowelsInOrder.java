import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubstringsOfAllVowelsInOrder {

    public int longestBeautifulSubstring(String word) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxLen = 0;
        // Now using the sliding window technique
        int i = 0;
        int j = 0;
        char prevChar = 'a';
        while (i < word.length() && j < word.length()) {
            char currChar = word.charAt(j);
            int idxOfPrev = vowels.indexOf(prevChar);
            int idxOfCurr = vowels.indexOf(currChar);
            if (idxOfCurr == idxOfPrev || idxOfCurr == idxOfPrev + 1) {
                if (currChar == 'u' && word.charAt(i) == 'a') {
                    // track the maxLength only if we get a u for a previous a
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                j += 1;
            } else {
                // Slide the window to the right
                i = j;
            }
            prevChar = currChar;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringsOfAllVowelsInOrder obj = new LongestSubstringsOfAllVowelsInOrder();
        String s = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        // String s = "aeeeiiiioooauuuaeiou";
        System.out.println(obj.longestBeautifulSubstring(s));
    }
}
