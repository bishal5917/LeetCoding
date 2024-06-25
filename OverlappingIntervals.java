import java.util.Arrays;
import java.util.Comparator;

public class OverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        // Now time to erase overlapping intervals
        // Lets first sort intervals based upon ending
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        // Then time to go one by one and compare
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < prevEnd) {
                // means overlapped
                // gotta remove (prevEnd isn't updated)means dont consider
                count++;
            } else {
                // else update the prevEnd,dont remove
                prevEnd = curr[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        OverlappingIntervals obj = new OverlappingIntervals();
        int[][] intervals = {
                { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 }
        };
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }
}
