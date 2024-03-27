import java.util.PriorityQueue;

class SeatManager {

    PriorityQueue<Integer> pq = null;

    public SeatManager(int n) {
        this.pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.offer(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager obj = new SeatManager(5);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        obj.unreserve(2);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        obj.unreserve(5);
    }
}
