import java.util.Arrays;

public class FindChampionII {

    public int findChampion(int n, int[][] edges) {
        // Main task here is to find the indegrees
        int[] indegrees = new int[n];
        for (int[] edge : edges) {
            int toNode = edge[1];
            indegrees[toNode] = indegrees[toNode] + 1;
        }
        int zeroIndegreesCount = 0;
        int currChampion = -1;
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                currChampion = i;
                zeroIndegreesCount += 1;
            }
        }
        System.out.println(Arrays.toString(indegrees));
        return zeroIndegreesCount == 1 ? currChampion : -1;
    }

    public static void main(String[] args) {
        FindChampionII obj = new FindChampionII();
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 } };
        System.out.println(obj.findChampion(n, edges));
    }
}
