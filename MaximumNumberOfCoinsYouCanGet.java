import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        int coins = 0;
        // Doing this using two pointers + GREEDY APPROACH
        int n = piles.length;
        int l = 0;
        int r = n - 1;
        Arrays.sort(piles);
        // The trick is,giving bob the least one
        // Giving alice the largest one
        // Giving myself a second largest one
        while (l < r) {
            coins += piles[r - 1];
            l += 1;
            r -= 2;
        }
        return coins;
    }

    public static void main(String[] args) {
        MaximumNumberOfCoinsYouCanGet obj = new MaximumNumberOfCoinsYouCanGet();
        int[] piles = { 2, 4, 1, 2, 7, 8 };
        System.out.println(obj.maxCoins(piles));
    }
}
