import java.util.PriorityQueue;

public class MinAmountOfTimeToFillCups {

    public int fillCups(int[] amount) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : amount) {
            pq.add(num);
        }
        while (pq.peek() != 0) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != 0 && b != 0) {
                pq.offer(a - 1);
                pq.offer(b - 1);
            }
            if (a != 0 && b == 0) {
                pq.offer(a - 1);
                pq.offer(0);
            }
            time += 1;
        }
        return time;
    }

    public static void main(String[] args) {
        MinAmountOfTimeToFillCups obj = new MinAmountOfTimeToFillCups();
        int[] amount = { 5, 0, 0 };
        System.out.println(obj.fillCups(amount));
    }
}
