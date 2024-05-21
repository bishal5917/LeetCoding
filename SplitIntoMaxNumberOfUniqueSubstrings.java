import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SplitIntoMaxNumberOfUniqueSubstrings {

    int maxLen = 0;

    public int maxUniqueSplit(String s) {
        getUniqueSplits(s, new HashSet<>(), new ArrayList<>(), 0);
        return maxLen;
    }

    private List<String> getUniqueSplits(String s, HashSet<String> set, List<String> curr, int st) {
        // if reached end,track the size if its max
        if (st >= s.length()) {
            // System.out.println(curr);
            maxLen = Math.max(curr.size(), maxLen);
            return curr;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (st + i > s.length()) {
                continue;
            }
            // Now partition and add if isn't already considered
            String substr = s.substring(st, st + i);
            if (!set.contains(substr)) {
                curr.add(substr);
                set.add(substr);
                curr = getUniqueSplits(s, set, curr, st + i);
                set.remove(substr);
                curr.remove(curr.size() - 1);
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        SplitIntoMaxNumberOfUniqueSubstrings obj = new SplitIntoMaxNumberOfUniqueSubstrings();
        String s = "ababccc";
        System.out.println(obj.maxUniqueSplit(s));
    }
}
