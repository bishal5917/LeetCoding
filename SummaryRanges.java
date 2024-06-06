
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SummaryRanges {

    // Lets use a treemap
    // to keep in a sorted order
    TreeSet<Integer> set;

    public SummaryRanges() {
        this.set = new TreeSet<>();
    }

    public void addNum(int value) {
        // just add to the treemap
        set.add(value);
    }

    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList<>();
        if (set.isEmpty()) {
            return new int[0][2];
        }
        int left = -1;
        int prevVal = -1;
        for (int val : set) {
            if (left == -1) {
                left = val;
                prevVal = val;
            } else if (val != prevVal + 1) {
                // means disjointed
                intervals.add(new int[] { left, prevVal });
                left = val;
                prevVal = left;
            } else if (val == prevVal + 1) {
                prevVal = val;
            }
        }
        // add last if remaining
        intervals.add(new int[] { left, prevVal });
        // print
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        // Now time to return the intervals
        return intervals.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.getIntervals();
        obj.addNum(5);
        obj.addNum(6);
        obj.getIntervals();
    }
}
