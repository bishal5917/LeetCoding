import java.math.BigInteger;
import java.util.PriorityQueue;

public class FindKthLargestIntegerInArray {

    public String kthLargestNumber(String[] nums, int k) {
        BigInteger largest = new BigInteger("-1");
        PriorityQueue<BigInteger> pq = new PriorityQueue<>(
                (a, b) -> b.compareTo(a));
        for (String num : nums) {
            pq.offer(new BigInteger(num));
        }
        // Now finding the largest val
        while (!pq.isEmpty() && k > 0) {
            largest = pq.poll();
            k -= 1;
        }
        return largest.toString();
    }

    public static void main(String[] args) {
        FindKthLargestIntegerInArray obj = new FindKthLargestIntegerInArray();
        String[] nums = { "3", "6", "7", "10" };
        int k = 4;
        System.out.println(obj.kthLargestNumber(nums, k));
    }
}
