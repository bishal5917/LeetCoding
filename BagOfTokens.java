import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {
        int maxPossibleScore = 0;
        int score = 0;
        if (tokens.length == 0)
            return score;
        // Using two pointers
        int i = 0;
        int j = tokens.length - 1;
        Arrays.sort(tokens);
        while (i <= j) {
            if (power >= tokens[i]) {
                // then increase the score and decrease the power
                power -= tokens[i];
                score += 1;
                i += 1;
                maxPossibleScore = Math.max(score, maxPossibleScore);
            }
            // check if we can get power through scores
            else if (power < tokens[i]) {
                // check if we can get power through scores
                if (score > 0) {
                    // the exchange power
                    power += tokens[j];
                    score -= 1;
                    j -= 1;
                } else {
                    break;
                }
            }
        }
        System.out.println(power);
        return maxPossibleScore;
    }

    public static void main(String[] args) {
        BagOfTokens obj = new BagOfTokens();
        int[] tokens = { 26, 48, 87 };
        int power = 81;
        System.out.println(obj.bagOfTokensScore(tokens, power));
    }
}
