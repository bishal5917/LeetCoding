import java.util.Arrays;

public class FindXorOfNumbersThatAppearsTwice {

    public int duplicateNumbersXOR(int[] nums) {
        // Lets count the frequency first
        int xor = 0;
        int[] count = new int[51];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] += 1;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                xor ^= i;
            }
        }
        return xor;
    }

    public static void main(String[] args) {
        FindXorOfNumbersThatAppearsTwice obj = new FindXorOfNumbersThatAppearsTwice();
        int[] nums = { 1, 2, 2, 1 };
        System.out.println(obj.duplicateNumbersXOR(nums));
    }

}
