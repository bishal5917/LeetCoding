import java.util.Random;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int response = guess(mid);
            if (response == 0) {
                return mid;
            } else if (response == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // THIS FUNCTION WILL BE GIVEN BY LEETCODE
    private int guess(int n) {
        Random random = new Random();
        // Generates random numbers between 0 and 2, then subtracts 1
        int randomNumber = random.nextInt(3) - 1;
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower obj = new GuessNumberHigherOrLower();
        System.out.println(obj.guessNumber(10));
    }
}
