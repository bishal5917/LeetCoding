import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] nums = new int[cols];
        // Lets create an array step by step
        for (int r = 0; r < rows; r++) {
            fillArray(matrix, nums, r);
            area = Math.max(area, getLargestRectangle(nums));
            // System.out.println(Arrays.toString(nums));
        }
        // System.out.println(getLargestRectangle(new int[] { 3, 1, 3, 2, 2 }));
        return area;
    }

    private void fillArray(char[][] matrix, int[] nums, int r) {
        // we give the original nums and fill it
        // we create nums array for each rows
        // if 1 put 1 else put 0
        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[r][c] == '0') {
                nums[c] = 0;
            } else {
                nums[c] += 1;
            }
        }
    }

    // This approach is same as finding largest rectange in histogram
    private int getLargestRectangle(int[] nums) {
        int n = nums.length;
        int area = 0;
        Stack<int[]> st = new Stack<>();
        // we will store [index that can be extended backwards,curr height]
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (st.isEmpty()) {
                st.add(new int[] { i, curr });
                continue;
            }
            // We are trying to make monotonically increasing stack
            // In case if new one is lesser
            int lastPoppedPos = -1;
            while (!st.isEmpty() && curr < st.peek()[1]) {
                // means the previous cant be extended
                // calculate its area and pop it
                int currArea = (i - st.peek()[0]) * st.peek()[1];
                lastPoppedPos = st.peek()[0];
                area = Math.max(area, currArea);
                st.pop();
            }
            if (lastPoppedPos != -1) {
                // means that new one can be extended to lastPoppedPos
                st.push(new int[] { lastPoppedPos, curr });
            }
            // In case if new one is greater
            if (!st.isEmpty() && curr > st.peek()[1]) {
                // lets just push in this case
                st.push(new int[] { i, curr });
            }
        }
        printStack(st);
        // Now for the remaining parts
        while (!st.isEmpty()) {
            // These can be extended till the end
            int[] curr = st.pop();
            int currArea = (n - curr[0]) * curr[1];
            area = Math.max(area, currArea);
        }
        return area;
    }

    private void printStack(Stack<int[]> st) {
        for (int i = 0; i < st.size(); i++) {
            System.out.println(Arrays.toString(st.get(i)));
        }
    }

    public static void main(String[] args) {
        MaximalRectangle obj = new MaximalRectangle();
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        System.out.println(obj.maximalRectangle(matrix));
    }
}
