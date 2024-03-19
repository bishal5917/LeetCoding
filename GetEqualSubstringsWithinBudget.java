import java.util.Arrays;

public class GetEqualSubstringsWithinBudget {

    public int equalSubstring(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];
        // Lets calculate the difference of s to t
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            arr[i] = Math.abs((int) a - (int) b);
        }
        System.out.println(Arrays.toString(arr));
        // USING VARIABLE SLIDING WINDOW TECHNIQUE
        int i = 0;
        int j = 0;
        int maxLen = 0;
        while (i < arr.length && j < arr.length) {
            // if the next one is zero,even though we are out cost,we can keep it
            if ((maxCost <= 0 || arr[j] > maxCost) && arr[j] != 0) {
                // decrease from left,while collecting the cost
                maxCost += arr[i];
                i += 1;
            } else {
                // increase from right,while using the cost
                maxCost -= arr[j];
                maxLen = Math.max(maxLen, j - i + 1);
                j += 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget obj = new GetEqualSubstringsWithinBudget();
        String s = "abcd";
        String t = "bcdf";
        System.out.println(obj.equalSubstring(s, t, 3));
    }
}
