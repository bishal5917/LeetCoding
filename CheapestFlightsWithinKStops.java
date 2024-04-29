import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        long[] ans = new long[n];
        long[] temp = new long[n];
        // fill initail ans with Positive Infinity,we will keep updating
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Long.MAX_VALUE;
            temp[i] = Long.MAX_VALUE;
        }
        // source to source will be 0
        ans[src] = 0;
        temp[src] = 0;
        // NOW WE WILL RUN BELLMAN FORD ALGORITHM k+1 times
        while (k >= 0) {
            for (int i = 0; i < flights.length; i++) {
                int[] flight = flights[i];
                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];
                if (ans[from] == Long.MAX_VALUE) {
                    // if we add to infinity,not going to be less,continue
                    continue;
                }
                // else add the prev cost and current cost and try to update
                long newCost = ans[from] + cost;
                // check from temp and add to the temp
                temp[to] = Math.min(temp[to], newCost);
            }
            System.out.println(Arrays.toString(temp));
            // Now update the ans to temp for next iteration
            for (int i = 0; i < temp.length; i++) {
                ans[i] = temp[i];
            }
            k -= 1;
        }
        return ans[dst] == Long.MAX_VALUE ? -1 : (int) ans[dst];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int n = 3;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}
