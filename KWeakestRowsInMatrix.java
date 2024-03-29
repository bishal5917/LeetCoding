import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] weakest = new int[k];
        // First gotta count the soldiers in each row
        int[] soldiers = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int sols = 0;
            for (int people : row) {
                if (people == 1) {
                    sols += 1;
                }
            }
            soldiers[i] = sols;
        }
        // Now time to put in a heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < soldiers.length; i++) {
            pq.offer(new int[] { i, soldiers[i] });
        }
        // Now pop from the heap k times and put in ans
        int idx = 0;
        while (k > 0) {
            int[] val = pq.poll();
            weakest[idx++] = val[0];
            k -= 1;
        }
        return weakest;
    }

    public static void main(String[] args) {
        KWeakestRowsInMatrix obj = new KWeakestRowsInMatrix();
        int[][] mat = { { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };
        int k = 3;
        int[] ans = obj.kWeakestRows(mat, k);
        System.out.println(Arrays.toString(ans));
    }
}
