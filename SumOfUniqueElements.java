import java.util.HashMap;

public class SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> bucket = new HashMap<>();

        for (int num : nums) {
            if (bucket.get(num) == null) {
                bucket.put(num, 1);
            } else {
                int prev = bucket.get(num);
                bucket.put(num, prev + 1);
            }
        }

        // Now sum the unique integers
        int sum = 0;
        for (int num : nums) {
            if (bucket.get(num) == 1) {
                sum = sum + num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfUniqueElements obj = new SumOfUniqueElements();
        int[] nums = { 1, 2, 3, 2 };
        System.out.println(obj.sumOfUnique(nums));
    }

}
