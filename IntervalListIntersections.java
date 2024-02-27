import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intervals = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] f = firstList[i];
            int[] s = secondList[j];
            int maxStarting = Math.max(f[0], s[0]);
            int minEnding = Math.min(f[1], s[1]);
            if (maxStarting <= minEnding) {
                // means there an overlapping interval,so add it
                intervals.add(new int[] { maxStarting, minEnding });
            }
            if (f[1] < s[1]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        // Now append all the intersections and finally return
        int[][] intersectionArray = new int[intervals.size()][2];
        for (int idx = 0; idx < intervals.size(); idx++) {
            intersectionArray[idx] = intervals.get(idx);
        }
        printIntervals(intervals);
        return intersectionArray;
    }

    private void printIntervals(List<int[]> intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static void main(String[] args) {
        IntervalListIntersections obj = new IntervalListIntersections();
        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        obj.intervalIntersection(firstList, secondList);
    }

}
