import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        // gotta generate start and end
        String st = "";
        String end = "123450";
        // lets get start
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                st += board[i][j];
            }
        }
        return bfsHelper(board, st, end);
    }

    private int bfsHelper(int[][] board, String st, String end) {
        int steps = 0;
        // Lets point out the possible swaps for an index
        int[][] swapDirs = {
                { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }
        };
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(st);
        q.offer(st);
        while (!q.isEmpty()) {
            int size = q.size();
            // Gotta find levels required
            for (int i = 0; i < size; i++) {
                // poll from the queue
                String curr = q.poll();
                if (curr.equals(end)) {
                    return steps;
                }
                int idx = curr.indexOf('0');
                // Now swap and check in all the possible directions
                for (int dir : swapDirs[idx]) {
                    // Swap in these directions
                    String next = swap(curr, idx, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    q.offer(next);
                }
            }
            steps += 1;
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        StringBuilder sbr = new StringBuilder(s);
        sbr.setCharAt(i, s.charAt(j));
        sbr.setCharAt(j, s.charAt(i));
        return sbr.toString();
    }

    public static void main(String[] args) {
        SlidingPuzzle obj = new SlidingPuzzle();
        int[][] board = {
                { 1, 2, 3 }, { 4, 0, 5 }
        };
        System.out.println(obj.slidingPuzzle(board));
    }
}
