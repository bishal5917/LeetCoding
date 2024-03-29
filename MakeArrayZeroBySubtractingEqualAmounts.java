import java.util.PriorityQueue;

public class MakeArrayZeroBySubtractingEqualAmounts {

    public int minimumOperations(int[] nums) {
        int ops = 0;
        // Using the priorityQueue
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int num : nums) {
            if (num != 0) {
                minheap.offer(num);
            }
        }
        while (!minheap.isEmpty()) {
            // take the minimum and subtract
            ops += 1;
            int min = minheap.poll();
            minheap.clear();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    // subtract
                    int rem = nums[i] - min;
                    nums[i] = rem;
                    if (rem > 0) {
                        minheap.offer(rem);
                    }
                }
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        MakeArrayZeroBySubtractingEqualAmounts obj = new MakeArrayZeroBySubtractingEqualAmounts();
        int[] nums = { 1, 5, 0, 3, 5 };
        System.out.println(obj.minimumOperations(nums));
    }
}
