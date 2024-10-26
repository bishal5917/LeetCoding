import java.util.HashMap;
import java.util.Map;

public class CheckIfCharactersHaveSameOccurences {

    public boolean areOccurrencesEqual(String s) {
        int count = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (count == -1) {
                count = entry.getValue();
            }
            if (count != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfCharactersHaveSameOccurences obj = new CheckIfCharactersHaveSameOccurences();
        String s = "abacbc";
        System.out.println(obj.areOccurrencesEqual(s));
    }

}
