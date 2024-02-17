import java.util.Arrays;
import java.util.HashMap;

public class FindPrefixCommonArray {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int previouslyCommon = 0;
        int[] ans = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            // Now add to hashmap
            if (bucket.get(A[i]) == null) {
                // add to bucket
                bucket.put(A[i], 1);
            } else {
                previouslyCommon += 1;
                bucket.put(A[i], 2);
            }
            if (bucket.get(B[i]) == null) {
                // add to bucket
                bucket.put(B[i], 1);
            } else {
                previouslyCommon += 1;
                bucket.put(B[i], 2);
            }
            // add the common we had finally
            ans[i] = previouslyCommon;
        }
        return ans;
    }

    public static void main(String[] args) {
        FindPrefixCommonArray obj = new FindPrefixCommonArray();
        int[] A = { 1, 3, 2, 4 };
        int[] B = { 3, 1, 2, 4 };
        int[] ans = obj.findThePrefixCommonArray(A, B);
        System.out.println(Arrays.toString(ans));

    }
}