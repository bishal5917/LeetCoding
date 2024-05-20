import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaxLengthOfConcatenatedSubstrings {

    int count = 0;

    public int maxLength(List<String> arr) {
        dfsHelper(arr, count, new ArrayList<>());
        return count;
    }

    private List<String> dfsHelper(List<String> arr, int idx, List<String> curr) {
        int size = getUniqueSize(curr);
        if (size == -1) {
            return curr;
        } else {
            // System.out.println(curr);
            count = Math.max(count, size);
        }
        for (int i = idx; i < arr.size(); i++) {
            curr.add(arr.get(i));
            curr = dfsHelper(arr, i + 1, curr);
            curr.remove(curr.size() - 1);
        }
        return curr;
    }

    private int getUniqueSize(List<String> curr) {
        HashSet<Character> set = new HashSet<>();
        for (String s : curr) {
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    return -1;
                }
                set.add(c);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        MaxLengthOfConcatenatedSubstrings obj = new MaxLengthOfConcatenatedSubstrings();
        List<String> arr = new ArrayList<>(Arrays.asList("un", "iq", "ue"));
        System.out.println(obj.maxLength(arr));
    }
}
