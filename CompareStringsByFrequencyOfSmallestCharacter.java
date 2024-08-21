import java.util.Arrays;
import java.util.HashMap;

public class CompareStringsByFrequencyOfSmallestCharacter {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = getF(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            w[i] = getF(words[i]);
        }
        Arrays.sort(w);
        // We do this using binary search
        for (int i = 0; i < q.length; i++) {
            int curr = q[i];
            int val = binarySearch(curr, w);
            // System.out.println(val);
            ans[i] = val;
        }
        System.out.println(Arrays.toString(q));
        System.out.println(Arrays.toString(w));
        return ans;
    }

    private int binarySearch(int target, int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums.length - l;
    }

    private int getF(String str) {
        char smallest = 'z';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (Character.compare(c, smallest) < 0) {
                smallest = c;
            }
        }
        return map.get(smallest);
    }

    public static void main(String[] args) {
        CompareStringsByFrequencyOfSmallestCharacter obj = new CompareStringsByFrequencyOfSmallestCharacter();
        String[] queries = { "bbb", "cc" };
        String[] words = { "a", "aa", "aaa", "aaaa" };
        int[] ans = obj.numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(ans));
    }
}
