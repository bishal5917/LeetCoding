import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOccurencesOfAnElementInArray {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] occurs = new int[queries.length];
        // we gotta find queries[i]th occurence of x in an Array
        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                idxs.add(i);
            }
        }
        // System.out.println(idxs);
        // Now lets find the result
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            if (query - 1 >= idxs.size()) {
                occurs[i] = -1;
            } else {
                occurs[i] = idxs.get(query - 1);
            }
        }
        return occurs;
    }

    public static void main(String[] args) {
        FindOccurencesOfAnElementInArray obj = new FindOccurencesOfAnElementInArray();
        int[] nums = { 1, 3, 1, 7 };
        int[] queries = { 1, 3, 2, 4 };
        int x = 1;
        int[] ans = obj.occurrencesOfElement(nums, queries, x);
        System.out.println(Arrays.toString(ans));
    }
}
