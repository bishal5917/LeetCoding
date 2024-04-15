public class MaximumCountOfPositiveAndNegativeInteger {

    public int maximumCount(int[] nums) {
        int lastNeg = -1;
        int firstPos = -1;
        int l = 0;
        int r = nums.length - 1;
        // Lets find the last occurence of the negative integer
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < 0) {
                lastNeg = mid;
                if (mid + 1 < nums.length && nums[mid + 1] >= 0) {
                    break;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = 0;
        r = nums.length - 1;
        // Lets find the first occurence of the positive integer
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > 0) {
                firstPos = mid;
                if (mid - 1 >= 0 && nums[mid - 1] <= 0) {
                    break;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int positives = 0;
        int negatives = 0;
        if (firstPos != -1) {
            positives = nums.length - firstPos;
        }
        if (lastNeg != -1) {
            negatives = lastNeg + 1;
        }
        return Math.max(positives, negatives);
    }

    public static void main(String[] args) {
        MaximumCountOfPositiveAndNegativeInteger obj = new MaximumCountOfPositiveAndNegativeInteger();
        int[] nums = { -2, -1, -1, 1, 2, 3 };
        System.out.println(obj.maximumCount(nums));
    }
}
