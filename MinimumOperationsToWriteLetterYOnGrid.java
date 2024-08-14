import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MinimumOperationsToWriteLetterYOnGrid {

    public int minimumOperationsToWriteY(int[][] grid) {
        int ops = 100;
        int n = grid.length;
        List<List<Integer>> yIdxs = new ArrayList<>();
        HashSet<List<Integer>> yIdxsSet = new HashSet<>();
        int mid = n / 2;
        yIdxs.add(Arrays.asList(mid, mid));
        yIdxsSet.add(Arrays.asList(mid, mid));
        // Lets find the co-ordinates required for y
        // Time to add left part of y
        int x = mid - 1;
        int y = mid - 1;
        while (x >= 0 && y >= 0) {
            yIdxs.add(Arrays.asList(x, y));
            yIdxsSet.add(Arrays.asList(x, y));
            x -= 1;
            y -= 1;
        }
        // Time to add right part of y
        x = mid - 1;
        y = mid + 1;
        while (x >= 0 && y < n) {
            yIdxs.add(Arrays.asList(x, y));
            yIdxsSet.add(Arrays.asList(x, y));
            x -= 1;
            y += 1;
        }
        // Time to add bottom part of y
        x = mid + 1;
        y = mid;
        while (x < n) {
            yIdxs.add(Arrays.asList(x, y));
            yIdxsSet.add(Arrays.asList(x, y));
            x += 1;
        }
        // Gotta try all the combinations,greedy wont work
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (i != j) {
                    int val = tryChanging(yIdxs, yIdxsSet, grid, i, j);
                    ops = Math.min(ops, val);
                }
            }
        }
        return ops;
    }

    private int tryChanging(List<List<Integer>> idxs, HashSet<List<Integer>> yIdxsSet, int[][] grid, int a, int b) {
        int ops = 0;
        int n = grid.length;
        for (List<Integer> num : idxs) {
            int i = num.get(0);
            int j = num.get(1);
            if (grid[i][j] != a) {
                ops++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!yIdxsSet.contains(Arrays.asList(i, j))) {
                    if (grid[i][j] != b) {
                        ops++;
                    }
                }
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToWriteLetterYOnGrid obj = new MinimumOperationsToWriteLetterYOnGrid();
        int[][] grid = {
                { 0, 1, 0, 1, 0 },
                { 2, 1, 0, 1, 2 },
                { 2, 2, 2, 0, 1 },
                { 2, 2, 2, 2, 2 },
                { 2, 1, 2, 2, 2 }
        };
        System.out.println(obj.minimumOperationsToWriteY(grid));
    }
}