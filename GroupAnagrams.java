import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//WORKED BUT TIME LIMIT EXCEEDED
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anags = new ArrayList<>();
        // Run till we have grouped all the words
        int grouped = 0;
        // Grouping empty strings separately
        List<String> emptyStringGroups = new ArrayList<>();
        while (grouped != strs.length) {
            List<String> currentAnags = new ArrayList<>();
            HashMap<Character, Integer> bucketA = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] == "-1") {
                    continue;
                }
                if (strs[i].isEmpty()) {
                    // add the empty string to separate groups
                    emptyStringGroups.add("");
                    grouped += 1;
                    strs[i] = "-1";
                    continue;
                }
                if (bucketA.isEmpty()) {
                    // then create an anagram for that bucket
                    for (char c : strs[i].toCharArray()) {
                        if (bucketA.get(c) == null) {
                            bucketA.put(c, 1);
                        } else {
                            int newCount = bucketA.get(c) + 1;
                            bucketA.put(c, newCount);
                        }
                    }
                    // then add it to current anagrams
                    currentAnags.add(strs[i]);
                    // mark as grouped
                    grouped += 1;
                    strs[i] = "-1";
                } else {
                    // create a bucket and check if matches with the previous bucket
                    HashMap<Character, Integer> bucketB = new HashMap<>();
                    for (char c : strs[i].toCharArray()) {
                        if (bucketB.get(c) == null) {
                            bucketB.put(c, 1);
                        } else {
                            int newCount = bucketB.get(c) + 1;
                            bucketB.put(c, newCount);
                        }
                    }
                    if (checkIfSame(bucketA, bucketB)) {
                        // then add it to current anagrams
                        currentAnags.add(strs[i]);
                        // mark as grouped
                        grouped += 1;
                        strs[i] = "-1";
                    }
                }
            }
            if (!currentAnags.isEmpty()) {
                anags.add(currentAnags);
            }
        }
        // add empty string groups to anagrams if any
        if (!emptyStringGroups.isEmpty()) {
            anags.add(emptyStringGroups);
        }
        return anags;
    }

    private boolean checkIfSame(HashMap<Character, Integer> bucketA, HashMap<Character, Integer> bucketB) {
        if (bucketA.size() != bucketB.size()) {
            return false;
        }
        // Now check if two hashmaps are equal or not
        for (Map.Entry<Character, Integer> entry : bucketA.entrySet()) {
            if (!entry.getValue().equals(bucketB.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> anags = obj.groupAnagrams(strs);
        System.out.println(anags);
    }

}
