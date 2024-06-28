import java.util.HashMap;
import java.util.Map;

public class MinimumStepsToMakeAnagram {

    public int minSteps(String s, String t) {
        int count = 0;
        // Hashmap to the rescue
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char c : s.toCharArray()) {
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        System.out.println(smap);
        System.out.println(tmap);
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (!smap.containsKey(entry.getKey())) {
                count += entry.getValue();
            } else {
                // if it contains
                // we gotta remove the extra one
                int valInS = smap.get(entry.getKey());
                if (entry.getValue() > valInS) {
                    count += entry.getValue() - valInS;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumStepsToMakeAnagram obj = new MinimumStepsToMakeAnagram();
        String s = "leetcode";
        String t = "practice";
        System.out.println(obj.minSteps(s, t));
    }
}
