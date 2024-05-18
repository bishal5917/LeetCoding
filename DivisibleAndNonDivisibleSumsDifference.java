public class DivisibleAndNonDivisibleSumsDifference {

    public int differenceOfSums(int n, int m) {
        int countA = 0;
        int countB = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                countA += i;
            } else {
                countB += i;
            }
        }
        return countA - countB;
    }

    public static void main(String[] args) {
        DivisibleAndNonDivisibleSumsDifference obj = new DivisibleAndNonDivisibleSumsDifference();
        int n = 10;
        int m = 3;
        System.out.println(obj.differenceOfSums(n, m));
    }
}