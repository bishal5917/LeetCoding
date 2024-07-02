import java.util.Arrays;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public int partitionArray(int[] nums, int k) {
        int partitions = 0;
        Arrays.sort(nums);
        // we track minimim and the maximum only
        int currMin = Integer.MAX_VALUE;
        int currMax = -1;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            // Lets update the currMin and currMax
            currMin = Math.min(currMin, curr);
            currMax = Math.max(currMax, curr);
            if (currMax - currMin > k) {
                partitions += 1;
                currMin = curr;
                currMax = curr;
            }
        }
        // System.out.println(currMin + "--" + currMax);
        if (currMax - currMin <= k) {
            partitions++;
        }
        return partitions;
    }

    public static void main(String[] args) {
        PartitionArraySuchThatMaximumDifferenceIsK obj = new PartitionArraySuchThatMaximumDifferenceIsK();
        int[] nums = { 3, 6, 1, 2, 5 };
        int k = 2;
        System.out.println(obj.partitionArray(nums, k));
    }
}
