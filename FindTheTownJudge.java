import java.util.Arrays;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        // Lets find the indegrees and outdegrees of all n
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for (int[] edge : trust) {
            int left = edge[0];
            int right = edge[1];
            out[left] += 1;
            in[right] += 1;
        }
        System.out.println(Arrays.toString(in));
        System.out.println(Arrays.toString(out));
        // Find whose indegree is n-1 and outdegree is 0
        for (int i = 0; i < in.length; i++) {
            if (in[i] == n - 1 && out[i] == 0 && i != 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge obj = new FindTheTownJudge();
        int n = 3;
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        System.out.println(obj.findJudge(n, trust));
    }
}