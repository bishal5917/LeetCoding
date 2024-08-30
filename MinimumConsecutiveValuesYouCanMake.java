import java.util.Arrays;

public class MinimumConsecutiveValuesYouCanMake {

    public int getMaximumConsecutive(int[] coins) {
        // start with 1 because we can always make one as we have 0
        int maxVal = 1;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > maxVal) {
                break;
            }
            maxVal += coin;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        MinimumConsecutiveValuesYouCanMake obj = new MinimumConsecutiveValuesYouCanMake();
        int[] coins = { 1, 1, 1, 4 };
        System.out.println(obj.getMaximumConsecutive(coins));
    }
}
