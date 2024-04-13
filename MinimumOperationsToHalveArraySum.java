import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {

    public int halveArray(int[] nums) {
        // Lets first sum and gotta use a min heap
        double sum = 0;
        double half = 0;
        int ops = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        // Iterate and put in queue
        for (int num : nums) {
            pq.offer((double) num);
            sum += num;
        }
        half = sum / 2;
        // Now time to find the min ops
        while (sum >= half && !pq.isEmpty()) {
            // poll the greatest from the queue
            double max = pq.poll();
            sum -= max;
            max = max / 2;
            pq.offer(max);
            sum += max;
            ops += 1;
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToHalveArraySum obj = new MinimumOperationsToHalveArraySum();
        int[] nums = { 18, 22, 62, 61, 1, 88, 17, 98, 38, 32, 51, 57, 7, 29, 40, 61, 62, 13, 89, 41, 73, 85, 88, 60, 59,
                76, 71, 76, 76, 41, 29, 43, 19, 9, 79 };
        System.out.println(obj.halveArray(nums));
    }
}