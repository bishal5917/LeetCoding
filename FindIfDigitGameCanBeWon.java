public class FindIfDigitGameCanBeWon {

    public boolean canAliceWin(int[] nums) {
        int singleDigitSum = 0;
        int doubleDigitSum = 0;
        for (int num : nums) {
            if (num % 10 == num) {
                // single digit
                singleDigitSum += num;
            } else {
                doubleDigitSum += num;
            }
        }
        return singleDigitSum != doubleDigitSum;
    }

    public static void main(String[] args) {
        FindIfDigitGameCanBeWon obj = new FindIfDigitGameCanBeWon();
        int[] nums = { 1, 2, 3, 4, 10 };
        System.out.println(obj.canAliceWin(nums));
    }
}
