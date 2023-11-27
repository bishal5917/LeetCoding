package KeyboardRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {

    public String[] findWords(String[] words) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        for (int w = 0; w < words.length; w++) {
            String word = words[w];
            Integer ansA = containsChar(word, firstRow);
            Integer ansB = containsChar(word, secondRow);
            Integer ansC = containsChar(word, thirdRow);
            if (ansA == word.length() || ansB == word.length() || ansC == word.length()) {
                ans.add(word);
            }
        }
        // Convert ArrayList to String array
        String[] resultArray = ans.toArray(new String[0]);
        System.out.println(Arrays.toString(resultArray));
        return resultArray;
    }

    public Integer containsChar(String toCheck, String checkIn) {
        Integer count = 0;
        for (int i = 0; i < toCheck.length(); i++) {
            char letterChild = toCheck.toLowerCase().charAt(i);
            for (int j = 0; j < checkIn.length(); j++) {
                char letterParent = checkIn.charAt(j);
                if (letterChild == letterParent) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KeyboardRow obj = new KeyboardRow();
        String[] words = { "Alaska", "Hello", "Dad", "Peace" };
        obj.findWords(words);
    }
}