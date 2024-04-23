import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class DetonateTheMaximumBombs {

    public int maximumDetonation(int[][] bombs) {
        int maxDetonations = 0;
        for (int i = 0; i < bombs.length; i++) {
            // Running BFS for every bombs and tracking the max detonations
            int count = bfsHelper(bombs, i);
            maxDetonations = Math.max(maxDetonations, count);
        }
        return maxDetonations;
    }

    private int bfsHelper(int[][] bombs, int bomb) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(bomb);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited.contains(curr)) {
                continue;
            }
            count += 1;
            visited.add(curr);
            for (int i = 0; i < bombs.length; i++) {
                // check which which is in in range
                int[] currBomb = bombs[curr];
                int[] nextBomb = bombs[i];
                // checking if current bomb can detonate next bomb
                if (i != curr && canDetonateNext(currBomb, nextBomb)) {
                    queue.offer(i);
                }
            }
        }
        return count;
    }

    // check if b is in the range of a or not
    private boolean canDetonateNext(int[] a, int[] b) {
        // USING EUCLIDEAN DISTANCE
        long xDis = a[0] - b[0];
        long yDis = a[1] - b[1];
        long d = xDis * xDis + yDis * yDis;
        // radius of currently checking one
        long r = a[2];
        r = r * r;
        return d <= r;
    }

    public static void main(String[] args) {
        DetonateTheMaximumBombs obj = new DetonateTheMaximumBombs();
        int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        System.out.println(obj.maximumDetonation(bombs));
    }
}
