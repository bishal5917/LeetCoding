import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int[] smallest = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    double frac1 = (double) a[0] / a[1];
                    double frac2 = (double) b[0] / b[1];
                    return Double.compare(frac1, frac2);
                });
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.offer(new int[] { arr[i], arr[j] });
            }
        }
        // Now to find the kth one
        while (k > 0 && !pq.isEmpty()) {
            smallest = pq.poll();
            k -= 1;
        }
        return smallest;
    }

    public static void main(String[] args) {
        KthSmallestPrimeFraction obj = new KthSmallestPrimeFraction();
        int[] arr = { 1, 2, 3, 5 };
        int k = 3;
        int[] ans = obj.kthSmallestPrimeFraction(arr, k);
        System.out.println(Arrays.toString(ans));
    }
}
