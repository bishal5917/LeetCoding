import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MostStonesRemovedWithinSameRowOrColumn {

    public int removeStones(int[][] stones) {
        int connectedComponents = 0;
        HashSet<List<Integer>> visited = new HashSet<>();
        for (int[] stone : stones) {
            if (visited.contains(Arrays.asList(stone[0], stone[1]))) {
                continue;
            }
            connectedComponents += 1;
            dfsHelper(stones, visited, stone);
        }
        // We can remove total stones - connected components number of stones
        return stones.length - connectedComponents;
    }

    private void dfsHelper(int[][] stones, HashSet<List<Integer>> visited, int[] curr) {
        if (visited.contains(Arrays.asList(curr[0], curr[1]))) {
            return;
        }
        visited.add(Arrays.asList(curr[0], curr[1]));
        // Now go for all of its points in the same row or column
        for (int[] point : findStonesInSameRowOrColumn(stones, curr)) {
            dfsHelper(stones, visited, point);
        }
    }

    private List<int[]> findStonesInSameRowOrColumn(int[][] stones, int[] curr) {
        List<int[]> points = new ArrayList<>();
        for (int[] point : stones) {
            if ((point[0] == curr[0] || point[1] == curr[1])) {
                if (point[0] == curr[0] && point[1] == curr[1]) {
                    continue;
                }
                points.add(point);
            }
        }
        return points;
    }

    public static void main(String[] args) {
        MostStonesRemovedWithinSameRowOrColumn obj = new MostStonesRemovedWithinSameRowOrColumn();
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(obj.removeStones(stones));
    }
}
