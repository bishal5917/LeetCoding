import java.util.Arrays;

//DSU Without any Path Compression
//This question can be solved without considering any ranks also
class DSU {

    int[] parent;
    int[] rank;

    public DSU(int n) {
        this.parent = new int[n + 1];
        this.rank = new int[n + 1];
        // Fill parent as themselves at beginning
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // Function to find the parent of that node
    public int find(int node) {
        while (this.parent[node] != node) {
            node = this.parent[node];
        }
        return node;
    }

    // Function to perform union
    // if union is success without forming a cycle,returns true else false
    public boolean union(int x, int y) {
        // find parent
        int xParent = find(x);
        int yParent = find(y);
        if (xParent == yParent) {
            // return false coz if we connect this,it will form a cycle
            return false;
        }
        // check ranks of their parents
        int rankX = this.rank[xParent];
        int rankY = this.rank[yParent];
        if (rankX > rankY) {
            this.parent[yParent] = xParent;
        } else if (rankY > rankX) {
            this.parent[xParent] = yParent;
        } else {
            this.parent[xParent] = yParent;
            this.rank[xParent] += 1;
        }
        return true;
    }
}

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        RedundantConnection obj = new RedundantConnection();
        int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] ans = obj.findRedundantConnection(edges);
        System.out.println(Arrays.toString(ans));
    }
}
