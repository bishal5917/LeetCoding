import java.util.PriorityQueue;

class Location {
    String name;
    int cost;

    public Location(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class SORTracker {

    PriorityQueue<Location> maxHeap;
    PriorityQueue<Location> minHeap;

    public SORTracker() {
        this.maxHeap = new PriorityQueue<>(
                (a, b) -> a.cost != b.cost ? b.cost - a.cost : a.name.compareTo(b.name));
        this.minHeap = new PriorityQueue<>(
                (a, b) -> a.cost != b.cost ? a.cost - b.cost : a.name.compareTo(b.name));
    }

    public void add(String name, int score) {
        Location newLoc = new Location(name, score);
        minHeap.add(newLoc);
        maxHeap.add(minHeap.poll());
    }

    public String get() {
        Location max = maxHeap.poll();
        minHeap.offer(max);
        return max.name;
    }

    public static void main(String[] args) {
        SORTracker tracker = new SORTracker();
        tracker.add("bradford", 2);
        tracker.add("branford", 3);
        System.out.println(tracker.get());
    }
}
