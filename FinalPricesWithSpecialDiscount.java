import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithSpecialDiscount {

    public int[] finalPrices(int[] prices) {
        // Initialize and empty stack
        Stack<Integer> nsStack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (nsStack.isEmpty()) {
                nsStack.push(i);
                continue;
            }
            while (!nsStack.isEmpty() && prices[i] <= prices[nsStack.peek()]) {
                int idx = nsStack.pop();
                // And discount the prices for the indexes
                prices[idx] = prices[idx] - prices[i];
            }
            nsStack.push(i);
        }
        return prices;
    }

    public static void main(String[] args) {
        FinalPricesWithSpecialDiscount obj = new FinalPricesWithSpecialDiscount();
        int[] prices = { 10, 1, 1, 6 };
        int[] ans = obj.finalPrices(prices);
        System.out.println(Arrays.toString(ans));
    }
}
