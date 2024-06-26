import java.util.Arrays;

public class FindOriginalArrayOfPrefixXOR {

    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] og = new int[n];
        og[0] = pref[0];
        for (int i = 1; i < n; i++) {
            og[i] = pref[i] ^ pref[i - 1];
        }
        return og;
    }

    public static void main(String[] args) {
        FindOriginalArrayOfPrefixXOR obj = new FindOriginalArrayOfPrefixXOR();
        int[] pref = new int[] { 5, 2, 0, 3, 1 };
        int[] ans = obj.findArray(pref);
        System.out.println(Arrays.toString(ans));
    }
}
