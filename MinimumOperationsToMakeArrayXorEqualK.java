public class MinimumOperationsToMakeArrayXorEqualK {

    public int minOperations(int[] nums, int k) {
        int ops = 0;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // Lets compare the difference between these two strings
        String a = Integer.toBinaryString(xor);
        String b = Integer.toBinaryString(k);
        System.out.println(a);
        System.out.println(b);
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) != b.charAt(j)) {
                ops += 1;
            }
            i -= 1;
            j -= 1;
        }
        while (i >= 0) {
            if (a.charAt(i) == '1') {
                ops += 1;
            }
            i -= 1;
        }
        while (j >= 0) {
            if (b.charAt(j) == '1') {
                ops += 1;
            }
            j -= 1;
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayXorEqualK obj = new MinimumOperationsToMakeArrayXorEqualK();
        int[] nums = { 2, 1, 3, 4 };
        int k = 1;
        System.out.println(obj.minOperations(nums, k));
    }
}
