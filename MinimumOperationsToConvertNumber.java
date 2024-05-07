import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperationsToConvertNumber {

    public int minimumOperations(int[] nums, int start, int goal) {
        return bfsHelper(nums, start, goal);
    }

    private int bfsHelper(int[] nums, int start, int end) {
        int ops = 0;
        boolean[] visited = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == end) {
                    return ops;
                }
                if (curr < 0 || curr > 1000 || visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                // Now try to perform operations and add to queue
                for (int x = 0; x < nums.length; x++) {
                    int newAfterAdd = curr + nums[x];
                    int newAfterSub = curr - nums[x];
                    int newAfterXor = curr ^ nums[x];
                    queue.offer(newAfterAdd);
                    queue.offer(newAfterSub);
                    queue.offer(newAfterXor);
                }
            }
            ops += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumOperationsToConvertNumber obj = new MinimumOperationsToConvertNumber();
        int[] nums = { 2, 4, 12 };
        int start = 2;
        int goal = 12;
        System.out.println(obj.minimumOperations(nums, start, goal));
    }
}
