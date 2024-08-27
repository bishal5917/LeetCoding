import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class CharPair {
    char val;
    int count;

    public CharPair(char val, int count) {
        this.val = val;
        this.count = count;
    }
}

public class MinimumDeletionsToMakeCharactersFrequenciesUnique {

    public int minDeletions(String s) {
        int deletions = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        List<CharPair> chars = new ArrayList<>();
        HashSet<Integer> seenFreq = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            chars.add(new CharPair(entry.getKey(), entry.getValue()));
        }
        // Sorting the list in descending order based on count
        chars.sort(new Comparator<CharPair>() {
            @Override
            public int compare(CharPair p1, CharPair p2) {
                return Integer.compare(p2.count, p1.count);
            }
        });
        // Now time to remove the frequencies
        for (CharPair item : chars) {
            int freq = item.count;
            while (freq > 0 && seenFreq.contains(freq)) {
                deletions++;
                freq--;
            }
            if (freq > 0) {
                seenFreq.add(freq);
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeCharactersFrequenciesUnique obj = new MinimumDeletionsToMakeCharactersFrequenciesUnique();
        String s = "aaabbbcc";
        System.out.println(obj.minDeletions(s));
    }
}
