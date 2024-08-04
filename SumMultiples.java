public class SumMultiples {

    public int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumMultiples obj = new SumMultiples();
        int n = 7;
        System.out.println(obj.sumOfMultiples(n));
    }
}
