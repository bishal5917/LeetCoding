import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Letter {
    Character val;
    int count;

    public Letter(Character val, int count) {
        this.val = val;
        this.count = count;
    }
}

public class MinimumPushesToTypeWordII {

    public int minimumPushes(String word) {
        int pushes = 0;
        // That one with the maximum number of occurence,maps the first one
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        // we push the key,value in a list and sort by descending order
        List<Letter> letters = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            letters.add(new Letter(entry.getKey(), entry.getValue()));
        }
        // Now sort those letters based on values in descending order
        // We are using a custom comparator
        Collections.sort(letters, new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                return Integer.compare(o2.count, o1.count); // For descending order
            }
        });
        // That one with the maximum number of occurence,maps the first one
        HashMap<Integer, List<Character>> map = new HashMap<>();
        for (int i = 2; i <= 9; i++) {
            map.put(i, new ArrayList<>());
        }
        System.out.println(count);
        // Now the time to map the letter
        int start = 2;
        for (Letter letter : letters) {
            while (map.get(start).size() == 4) {
                start++;
                if (start == 10) {
                    start = 2;
                }
            }
            map.get(start).add(letter.val);
            pushes += letter.count * map.get(start).size();
            start++;
            if (start == 10) {
                start = 2;
            }
        }
        System.out.println(map);
        return pushes;
    }

    public static void main(String[] args) {
        MinimumPushesToTypeWordII obj = new MinimumPushesToTypeWordII();
        String word = "xyzxyzxyzxyz";
        System.out.println(obj.minimumPushes(word));
    }
}
