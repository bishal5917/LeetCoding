import java.util.Arrays;

public class MaximumIcecreamBars {

    public int maxIceCream(int[] costs, int coins) {
        int icecreams = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (cost > coins) {
                break;
            }
            coins -= cost;
            icecreams++;
        }
        return icecreams;
    }

    public static void main(String[] args) {
        MaximumIcecreamBars obj = new MaximumIcecreamBars();
        int[] costs = { 1, 3, 2, 4, 1 };
        int coins = 7;
        System.out.println(obj.maxIceCream(costs, coins));
    }
}
