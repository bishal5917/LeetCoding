import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        String[] ranking = new String[score.length];
        String gold = "Gold Medal";
        String silver = "Silver Medal";
        String bronze = "Bronze Medal";
        int rank = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        // Lets push each of them
        for (int i = 0; i < score.length; i++) {
            pq.offer(new int[] { i, score[i] });
        }
        // lets rank them now
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int idx = curr[0];
            if (rank == 1) {
                ranking[idx] = gold;
            } else if (rank == 2) {
                ranking[idx] = silver;
            } else if (rank == 3) {
                ranking[idx] = bronze;
            } else {
                ranking[idx] = String.valueOf(rank);
            }
            rank += 1;
        }
        return ranking;
    }

    public static void main(String[] args) {
        RelativeRanks obj = new RelativeRanks();
        int[] score = { 5, 4, 3, 2, 1 };
        String[] ans = obj.findRelativeRanks(score);
        System.out.println(Arrays.toString(ans));
    }
}
