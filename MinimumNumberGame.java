import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberGame {

    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int num : nums) {
            minheap.offer(num);
        }
        int idx = 0;
        // Now lets pop from the heap and put in arr
        while (!minheap.isEmpty()) {
            int alice = minheap.poll();
            int bob = minheap.poll();
            arr[idx++] = bob;
            arr[idx++] = alice;
        }
        return arr;
    }

    public static void main(String[] args) {
        MinimumNumberGame obj = new MinimumNumberGame();
        int[] game = { 5, 4, 2, 3 };
        int[] ans = obj.numberGame(game);
        System.out.println(Arrays.toString(ans));
    }
}
