import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        int n = costs.length / 2;
        // We sort them based upon people
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1] - a[0], b[1] - b[0]);
            }
        });
        // for (int[] row : costs) {
        // System.out.println(Arrays.toString(row));
        // }
        int peopleInA = 0;
        int peopleInB = 0;
        for (int[] cost : costs) {
            // Now send first n/2 to b and remaining to a
            if (peopleInB < n) {
                peopleInB++;
                totalCost += cost[1];
            } else if (peopleInA < n) {
                peopleInA++;
                totalCost += cost[0];
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        TwoCityScheduling obj = new TwoCityScheduling();
        int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
        System.out.println(obj.twoCitySchedCost(costs));
    }
}
