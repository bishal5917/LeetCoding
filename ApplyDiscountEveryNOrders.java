import java.util.HashMap;

public class ApplyDiscountEveryNOrders {

    int n;
    int dis;
    HashMap<Integer, Integer> productVsPrice;
    int runningCustomer = 0;

    public ApplyDiscountEveryNOrders(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.dis = discount;
        this.productVsPrice = new HashMap<>();
        // We put products and prices in a map
        for (int i = 0; i < products.length; i++) {
            int id = products[i];
            int price = prices[i];
            productVsPrice.put(id, price);
        }
    }

    public double getBill(int[] product, int[] amount) {
        runningCustomer++;
        double total = 0.0;
        double discount = 0.0;
        for (int i = 0; i < product.length; i++) {
            int prod = product[i];
            int amt = amount[i];
            total += amt * (productVsPrice.get(prod));
        }
        if (runningCustomer == n) {
            // we apply discount
            discount = ((double) dis / (double) 100) * total;
            runningCustomer = 0;
        }
        total -= discount;
        return total;
    }

    public static void main(String[] args) {
        int n = 3;
        int discount = 50;
        int[] products = { 1, 2, 3, 4, 5, 6, 7 };
        int[] prices = { 100, 200, 300, 400, 300, 200, 100 };
        ApplyDiscountEveryNOrders obj = new ApplyDiscountEveryNOrders(n, discount, products, prices);
        System.out.println(obj.getBill(new int[] { 1, 2 }, new int[] { 1, 2 }));
        System.out.println(obj.getBill(new int[] { 3, 7 }, new int[] { 10, 10 }));
        System.out.println(obj.getBill(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 1, 1, 1, 1, 1, 1, 1 }));
    }
}
