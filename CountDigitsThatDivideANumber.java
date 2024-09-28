public class CountDigitsThatDivideANumber {

    public int countDigits(int num) {
        int count = 0;
        for (int number = num; number > 0; number = number / 10) {
            int digit = number % 10;
            if (num % digit == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountDigitsThatDivideANumber obj = new CountDigitsThatDivideANumber();
        int num = 121;
        System.out.println(obj.countDigits(num));
    }
}
