public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int bank : account) {
                sum += bank;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        RichestCustomerWealth obj = new RichestCustomerWealth();
        int[][] accounts = { { 1, 2, 3 }, { 3, 2, 1 } };
        System.out.println(obj.maximumWealth(accounts));
    }
}
