public class FindIntegerAddedToArrayI {

    public int addedInteger(int[] nums1, int[] nums2) {
        // we gotta find the min of these two
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums1) {
            min1 = Math.min(min1, num);
        }
        for (int num : nums2) {
            min2 = Math.min(min2, num);
        }
        return min2 - min1;
    }

    public static void main(String[] args) {
        FindIntegerAddedToArrayI obj = new FindIntegerAddedToArrayI();
        int[] nums1 = { 2, 6, 4 };
        int[] nums2 = { 9, 7, 5 };
        System.out.println(obj.addedInteger(nums1, nums2));
    }
}
