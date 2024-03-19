public class MaxPointsFromCards {

    public int maxScore(int[] cardPoints, int k) {
        // First lets sum all the numbers while maintaining a sliding window of (n-k)
        int i = 0;
        int j = 0;
        int sum = 0;
        int maxScore = sum;
        int n = cardPoints.length;
        while (j < n) {
            if (j >= (n - k)) {
                sum += cardPoints[j];
            }
            j += 1;
        }
        // update maxScore
        maxScore = Math.max(maxScore, sum);
        // Take back j to the last of window
        j = n - k;
        // NOW SLIDE THE WINDOW
        while (j < cardPoints.length) {
            sum += cardPoints[i];
            sum -= cardPoints[j];
            maxScore = Math.max(maxScore, sum);
            i += 1;
            j += 1;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        MaxPointsFromCards obj = new MaxPointsFromCards();
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(obj.maxScore(cardPoints, k));
    }
}
