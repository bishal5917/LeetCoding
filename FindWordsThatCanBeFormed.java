import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormed {

    public int countCharacters(String[] words, String chars) {
        // Lets make a hashcount for chars
        HashMap<Character, Integer> parentBucket = new HashMap<>();
        for (char c : chars.toCharArray()) {
            if (parentBucket.get(c) == null) {
                parentBucket.put(c, 1);
            } else {
                parentBucket.put(c, parentBucket.get(c) + 1);
            }
        }
        int wordLenCount = 0;
        // Now for every word in words
        for (String word : words) {
            // create a separate bucket and match with the charBucket
            HashMap<Character, Integer> childBucket = new HashMap<>();
            for (char c : word.toCharArray()) {
                if (childBucket.get(c) == null) {
                    childBucket.put(c, 1);
                } else {
                    childBucket.put(c, childBucket.get(c) + 1);
                }
            }
            if (canCreate(childBucket, parentBucket)) {
                wordLenCount = wordLenCount + word.length();
            }
        }
        return wordLenCount;
    }

    private boolean canCreate(HashMap<Character, Integer> childBucket, HashMap<Character, Integer> parentBucket) {
        for (Map.Entry<Character, Integer> entry : childBucket.entrySet()) {
            int valInChild = childBucket.get(entry.getKey());
            if (parentBucket.get(entry.getKey()) == null || parentBucket.get(entry.getKey()) < valInChild) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";
        FindWordsThatCanBeFormed obj = new FindWordsThatCanBeFormed();
        System.out.println(obj.countCharacters(words, chars));
    }
}
