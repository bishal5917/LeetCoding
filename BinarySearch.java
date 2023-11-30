
public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int idx = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                idx = mid;
                break;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(idx);
        return idx;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        int[] nums = { 5 };
        obj.search(nums, 5);

    }
}
