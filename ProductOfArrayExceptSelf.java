import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        // Lets find the prefix and suffix product array
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];
        prefixProd[0] = nums[0];
        suffixProd[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i];
            suffixProd[n - i - 1] = suffixProd[n - i] * nums[n - i - 1];
        }
        // Now calculate the product using the prefix and postfix array
        // And store for first and last
        nums[0] = suffixProd[1];
        nums[n - 1] = prefixProd[n - 2];
        for (int i = 1; i + 1 < n; i++) {
            nums[i] = prefixProd[i - 1] * suffixProd[i + 1];
        }
        System.out.println(Arrays.toString(prefixProd));
        System.out.println(Arrays.toString(suffixProd));
        return nums;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        int[] ans = obj.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }

}
