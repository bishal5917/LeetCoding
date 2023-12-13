
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int item : stones) {
            maxHeap.offer(item);

        }

        while (maxHeap.size() > 1) {
            int firstOne = maxHeap.poll();
            int secondOne = maxHeap.poll();
            if (firstOne != secondOne) {
                maxHeap.offer(firstOne - secondOne);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {

        LastStoneWeight obj = new LastStoneWeight();
        int[] stones = { 3, 7, 2 };
        int ans = obj.lastStoneWeight(stones);
        System.out.println(ans);
    }

}
