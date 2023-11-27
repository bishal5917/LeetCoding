package RelativeRanks;

import java.util.Arrays;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] ans = new String[score.length];
        String first = "Gold Medal";
        String second = "Silver Medal";
        String third = "Bronze Medal";
        int maxNum = -1;
        int minNum = Integer.MAX_VALUE;
        for (int item : score) {
            maxNum = Math.max(maxNum, item);
            minNum = Math.min(minNum, item);
        }
        for (int i = 0; i < score.length; i++) {
            int diff = score[i] - minNum;
            int val = score.length - diff;
            ans[i] = String.valueOf(val);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void main(String[] args) {
        RelativeRanks obj = new RelativeRanks();
        int[] scores = { 100, 111, 111111 };
        obj.findRelativeRanks(scores);
    }
}