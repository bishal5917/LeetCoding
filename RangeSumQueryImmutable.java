public class RangeSumQueryImmutable {

    class NumArray {

        int[] arr = null;

        public NumArray(int[] nums) {
            this.arr = nums;
            // And lets calculate the PrefixSum
            for (int i = 1; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i];
            }
        }

        public int sumRange(int left, int right) {
            // now to calculate the sum range
            int totalSum = 0;
            // add the sum till right
            totalSum += arr[right];
            // Now remove the sum before left if valid
            if (left - 1 >= 0) {
                totalSum -= arr[left - 1];
            }
            return totalSum;
        }
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable mainObj = new RangeSumQueryImmutable();
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray obj = mainObj.new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}
