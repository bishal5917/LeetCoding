import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeparateTheDigitsInArray {

    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        for (int num : nums) {
            List<Integer> currDigits = new ArrayList<>();
            while (num > 0) {
                currDigits.add(num % 10);
                num = num / 10;
            }
            Collections.reverse(currDigits);
            digits.addAll(currDigits);
        }
        System.out.println(digits);
        int[] ans = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            ans[i] = digits.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        SeparateTheDigitsInArray obj = new SeparateTheDigitsInArray();
        int[] nums = { 13, 25, 83, 77 };
        obj.separateDigits(nums);
    }

}
