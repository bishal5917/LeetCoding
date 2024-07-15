import java.util.HashMap;

public class NumberOfGoodWaysToSplitString {

    public int numSplits(String s) {
        int count = 0;
        // Lets use two hashmaps,on for left and the other for right
        HashMap<Character, Integer> lefts = new HashMap<>();
        HashMap<Character, Integer> rights = new HashMap<>();
        // Lets make a map first for lefts and rights at idx 1 and idx 2 to n
        lefts.put(s.charAt(0), 1);
        // For the right part
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!rights.containsKey(c)) {
                rights.put(c, 1);
            } else {
                rights.put(c, rights.get(c) + 1);
            }
        }
        if (lefts.size() == rights.size()) {
            count++;
        }
        // Now time to go like sliding window and checking
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // Remove from the right
            if (rights.get(c) > 1) {
                rights.put(c, rights.get(c) - 1);
            } else {
                rights.remove(c);
            }
            // Add to the left
            if (!lefts.containsKey(c)) {
                lefts.put(c, 1);
            } else {
                lefts.put(c, lefts.get(c) + 1);
            }
            // Now check if we have distinct characters to the left and right
            if (lefts.size() == rights.size()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfGoodWaysToSplitString obj = new NumberOfGoodWaysToSplitString();
        String s = "aacaba";
        System.out.println(obj.numSplits(s));
    }
}
