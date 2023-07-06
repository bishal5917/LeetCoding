import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {

    public static void main(String[] args) {

        // count of characters
        String sentence = "bon bon said crazy pants to stay away from her and crazy pants cried";

        Map<Character, Integer> letterCountMap = new HashMap<>();

        char[] letterArray = sentence.toCharArray();

        for (char letter : letterArray) {
            Integer count = letterCountMap.get(letter);
            if (count == null) {
                letterCountMap.put(letter, 1);
            } else {
                letterCountMap.put(letter, count + 1);
            }
        }

        System.out.println(letterCountMap);

        // count of Strings

        Map<String, Integer> wordCountMap = new HashMap<>();

        String[] wordChars = sentence.split(" ");

        for (String word : wordChars) {
            Integer count = wordCountMap.get(word);
            if (count == null) {
                wordCountMap.put(word, 1);
            } else {
                wordCountMap.put(word, count + 1);
            }
        }

        System.out.println(wordCountMap);

    }

}
