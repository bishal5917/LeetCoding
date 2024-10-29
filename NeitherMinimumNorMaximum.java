public class NeitherMinimumNorMaximum {

    public int findNonMinOrMax(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num != max && num != min) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NeitherMinimumNorMaximum obj = new NeitherMinimumNorMaximum();
        int[] nums = { 3, 2, 1, 4 };
        System.out.println(obj.findNonMinOrMax(nums));
    }
}
