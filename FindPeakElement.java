public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        // lets do a binary search
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + (r - l) / 2);
            if (m - 1 >= 0 && nums[m - 1] > nums[m]) {
                // means peak can be on left side
                r = m - 1;
            } else if (m + 1 < nums.length && nums[m + 1] > nums[m]) {
                // means peak can be on right side
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(obj.findPeakElement(nums));
    }
}
