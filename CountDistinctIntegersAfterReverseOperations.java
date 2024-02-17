import java.util.HashSet;

public class CountDistinctIntegersAfterReverseOperations {

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> uniques = new HashSet<>();

        for (int num : nums) {
            uniques.add(num);
            uniques.add(reverseNum(num));
        }
        return uniques.size();
    }

    private int reverseNum(int num) {
        int reversed = 0;

        while (num > 0) {
            reversed = (reversed * 10) + (num % 10);
            num = num / 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 13, 10, 12, 31 };
        CountDistinctIntegersAfterReverseOperations obj = new CountDistinctIntegersAfterReverseOperations();
        int ans = obj.countDistinctIntegers(nums);
        System.out.println(ans);
    }

}
