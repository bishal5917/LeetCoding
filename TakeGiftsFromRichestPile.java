import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {

    public long pickGifts(int[] gifts, int k) {
        long val = 0;
        // Lets use the priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        // for k times,pop the greatest and add the square root back
        for (int i = 0; i < k; i++) {
            int max = maxHeap.poll();
            int root = (int) Math.sqrt(max);
            maxHeap.offer(root);
        }
        for (int gift : maxHeap) {
            val += gift;
        }
        return val;
    }

    public static void main(String[] args) {
        TakeGiftsFromRichestPile obj = new TakeGiftsFromRichestPile();
        int[] gifts = { 25, 64, 9, 4, 100 };
        System.out.println(obj.pickGifts(gifts, 4));
    }
}
