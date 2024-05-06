
public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        // Array for marking visited
        boolean[] visited = new boolean[arr.length];
        return dfsHelper(arr, visited, start, false);
    }

    private boolean dfsHelper(int[] arr, boolean[] visited, int curr, boolean reached) {
        if (curr < 0 || curr >= arr.length) {
            return reached;
        }
        if (visited[curr] == true) {
            return reached;
        }
        if (arr[curr] == 0) {
            reached = true;
            return reached;
        }
        visited[curr] = true;
        // Now go for next indexes
        reached = dfsHelper(arr, visited, curr + arr[curr], reached);
        reached = dfsHelper(arr, visited, curr - arr[curr], reached);
        return reached;
    }

    public static void main(String[] args) {
        JumpGameIII obj = new JumpGameIII();
        int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;
        System.out.println(obj.canReach(arr, start));
    }
}
