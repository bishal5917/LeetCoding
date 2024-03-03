public class MinimumCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {
        int minCommon = -1;
        // Lets use a two pointer approach
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                minCommon = nums1[i];
                break;
            } else if (nums1[i] < nums2[j]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        return minCommon;
    }

    public static void main(String[] args) {
        MinimumCommonValue obj = new MinimumCommonValue();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4 };
        System.out.println(obj.getCommon(nums1, nums2));
    }

}
