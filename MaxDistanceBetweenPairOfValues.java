public class MaxDistanceBetweenPairOfValues {

    public int maxDistance(int[] nums1, int[] nums2) {
        int distance = 0;
        // using the classic two pointer approach
        int i = 0;
        int j = 0;
        // i <= j and nums1[i] <= nums2[j].
        // the distance of the pair is j - i​​​​.
        while (i < nums1.length && j < nums2.length) {
            if (i <= j && nums1[i] <= nums2[j]) {
                distance = Math.max(distance, j - i);
                j += 1;
            } else {
                i += 1;
                j += 1;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        MaxDistanceBetweenPairOfValues obj = new MaxDistanceBetweenPairOfValues();
        int[] nums1 = { 55, 30, 5, 4, 2 };
        int[] nums2 = { 100, 20, 10, 10, 5 };
        System.out.println(obj.maxDistance(nums1, nums2));
    }

}
