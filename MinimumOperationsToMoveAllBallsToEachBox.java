import java.util.Arrays;

public class MinimumOperationsToMoveAllBallsToEachBox {

    // LINEAR COMPLEXITY
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] leftOps = new int[n];
        int[] rightOps = new int[n];
        int[] total = new int[n];
        // LEFT PART
        int leftBoxes = 0;
        leftBoxes += boxes.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            leftOps[i] = leftOps[i - 1] + leftBoxes;
            leftBoxes += boxes.charAt(i) == '1' ? 1 : 0;
        }
        // RIGHT PART
        int rightBoxes = 0;
        rightBoxes += boxes.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            rightOps[i] = rightOps[i + 1] + rightBoxes;
            rightBoxes += boxes.charAt(i) == '1' ? 1 : 0;
        }
        System.out.println(Arrays.toString(leftOps));
        System.out.println(Arrays.toString(rightOps));
        // NOW LETS ADD LEFT AND RIGHT TOGETHER AND RETURN TOTAL
        for (int i = 0; i < n; i++) {
            total[i] = leftOps[i] + rightOps[i];
        }
        return total;
    }

    // QUADRATIC COMPLEXITY
    public int[] minOperationsNaive(String boxes) {
        int n = boxes.length();
        int[] ops = new int[n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '0') {
                continue;
            }
            for (int j = 0; j < n; j++) {
                ops[j] += Math.abs(i - j);
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumOperationsToMoveAllBallsToEachBox obj = new MinimumOperationsToMoveAllBallsToEachBox();
        String boxes = "110";
        obj.minOperationsNaive(boxes);
        int[] ans = obj.minOperations(boxes);
        System.out.println(Arrays.toString(ans));
    }
}
