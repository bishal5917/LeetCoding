public class MaximizeTheConfusionOfExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        // lets find for T and F and return the max of them
        int maxTrue = maxConsecutiveAnswerHelper(answerKey, k, 'T');
        int maxFalse = maxConsecutiveAnswerHelper(answerKey, k, 'F');
        return Math.max(maxTrue, maxFalse);
    }

    private int maxConsecutiveAnswerHelper(String answerKey, int k, char ch) {
        int i = 0;
        int j = 0;
        int flips = k;
        int currMax = 0;
        while (i < answerKey.length() && j < answerKey.length()) {
            if (answerKey.charAt(j) == ch) {
                currMax = Math.max(currMax, j - i + 1);
                j += 1;
            } else {
                if (flips <= 0) {
                    if (answerKey.charAt(i) == ch) {
                        i += 1;
                    } else {
                        i += 1;
                        flips += 1;
                    }
                } else {
                    currMax = Math.max(currMax, j - i + 1);
                    flips -= 1;
                    j += 1;
                }
            }
        }
        return currMax;
    }

    public static void main(String[] args) {
        MaximizeTheConfusionOfExam obj = new MaximizeTheConfusionOfExam();
        String answerKey = "TFFT";
        int k = 1;
        System.out.println(obj.maxConsecutiveAnswers(answerKey, k));
    }
}
