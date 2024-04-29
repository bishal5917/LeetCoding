import java.util.PriorityQueue;

public class KruskalsMSTAlgorithm {

    private int minimumSpanningTree(int n, int[][] edges) {
        int totalCost = 0;
        // parent and size array for union-find operating
        int[] parent = new int[n];
        int[] size = new int[n];
        // Initialize size to 1,and parent to itself
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        // we put all those edges in the priority queue,min-heap
        // we should get the one with the lowest cost during polling
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]);
        // Add all edges to the priority queue
        for (int[] edge : edges) {
            pq.offer(edge);
        }
        // NOW STARTING THE ALGORITHM
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            boolean grouped = union(parent, size, a, b);
            // if union was successful,add the cost,else continue
            if (grouped == false) {
                continue;
            }
            totalCost += cost;
        }
        return totalCost;
    }

    // Now gotta implement union and find operation
    private boolean union(int[] parent, int[] size, int x, int y) {
        // lets find the parent of two nodes
        int parentA = find(parent, x);
        int parentB = find(parent, y);
        // if same just return false
        if (parentA == parentB) {
            return false;
        }
        // else find the size of both the parents
        int sizeA = size[parentA];
        int sizeB = size[parentB];
        // Now merge less sized one to the big sized
        if (sizeA > sizeB) {
            parent[y] = parentA;
            parent[parentB] = parentA;
            size[parentA] += sizeB;
        } else {
            parent[x] = parentB;
            parent[parentA] = parentB;
            size[parentB] += sizeA;
        }
        return true;
    }

    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {
        KruskalsMSTAlgorithm obj = new KruskalsMSTAlgorithm();
        int n = 10;
        // There are a total of 10 nodes (0-9)
        // and for edges (idx0=Node,idx1=Node,idx2=cost)
        int[][] edges = { { 0, 1, 5 }, { 0, 3, 4 }, { 0, 4, 1 }, { 4, 3, 2 },
                { 4, 5, 1 }, { 3, 1, 2 }, { 3, 5, 5 }, { 3, 6, 11 },
                { 3, 7, 2 }, { 1, 6, 4 }, { 5, 6, 7 }, { 6, 7, 1 },
                { 6, 8, 4 }, { 7, 2, 4 }, { 7, 8, 6 }, { 2, 8, 1 },
                { 2, 9, 2 }, { 8, 9, 0 } };
        // ANOTHER TEST CASE
        // int n=4;
        // int[][] edges = { { 0, 1, 10 }, { 1, 3, 15 }, { 2, 3, 4 }, { 2, 0, 6 }, { 0,
        // 3, 5 } };
        System.out.println(obj.minimumSpanningTree(n, edges));
    }
}
