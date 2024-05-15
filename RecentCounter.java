import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    // check [t-3000,t] inclusive in the queue

    Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        // offer the current
        queue.offer(t);
        // Now poll those that are not in range [t-3000,t]
        while (!queue.isEmpty()
                && (queue.peek() < (t - 3000) || queue.peek() > t)) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));
        System.out.println(obj.ping(100));
        System.out.println(obj.ping(3001));
        System.out.println(obj.ping(3002));
    }
}
