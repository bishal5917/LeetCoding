import java.util.Arrays;
import java.util.Comparator;

public class RearrageWordsInSequence {

    public String arrangeWords(String text) {
        StringBuilder ans = new StringBuilder();
        String[] word = text.split(" ");
        // Sort words based on their length using a custom comparator
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        for (int i = 0; i < word.length; i++) {
            if (i == 0) {
                ans.append(capitalizeFirstLetter(word[i]));
            } else {
                ans.append(word[i].toLowerCase());
            }
            if (i != word.length - 1) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    private String capitalizeFirstLetter(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static void main(String[] args) {
        RearrageWordsInSequence obj = new RearrageWordsInSequence();
        String text = "Leetcode is cool";
        System.out.println(obj.arrangeWords(text));
    }
}
