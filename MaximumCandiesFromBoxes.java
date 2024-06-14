import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumCandiesFromBoxes {

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candys = 0;
        // we gotta perform a bfs while tracking the candies collected yet
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        // add the initialBoxes to the queue
        for (int candy : initialBoxes) {
            q.offer(candy);
            seen.add(candy);
        }
        // Now lets start and try to get the candys
        HashSet<Integer> currKeys = new HashSet<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (visited.contains(curr)) {
                continue;
            }
            // check if open or closed
            if (status[curr] == 0 && !currKeys.contains(curr)) {
                // means cant open,just continue
                continue;
            }
            visited.add(curr);
            // add the keys
            for (int key : keys[curr]) {
                currKeys.add(key);
                // we can open if a box has been found yet
                if (seen.contains(key)) {
                    q.offer(key);
                }
            }
            // we track the candys
            candys += candies[curr];
            // Now add all contained boxes to queue
            for (int box : containedBoxes[curr]) {
                seen.add(box);
                q.offer(box);
            }
        }
        return candys;
    }

    public static void main(String[] args) {
        MaximumCandiesFromBoxes obj = new MaximumCandiesFromBoxes();
        int[] status = { 1, 0, 1, 0 };
        int[] candies = { 7, 5, 4, 100 };
        int[][] keys = { {}, {}, { 1 }, {} };
        int[][] containedBoxes = { { 1, 2 }, { 3 }, {}, {} };
        int[] initialBoxes = { 0 };
        System.out.println(obj.maxCandies(status, candies, keys, containedBoxes, initialBoxes));
    }
}
