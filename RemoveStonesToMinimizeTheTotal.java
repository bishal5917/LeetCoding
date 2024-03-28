import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public int minStoneSum(int[] piles, int k) {
        // Lets remove from the largest pile everytime
        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            sum += pile;
            pq.add(pile);
        }
        // Now lets pop from the heap k times
        for (int i = 0; i < k; i++) {
            int val = pq.poll();
            int remove = val / 2;
            sum -= remove;
            pq.offer(val - remove);
        }
        System.out.println(pq);
        return sum;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal obj = new RemoveStonesToMinimizeTheTotal();
        int[] piles = { 10000 };
        System.out.println(obj.minStoneSum(piles, 10000));
    }
}
