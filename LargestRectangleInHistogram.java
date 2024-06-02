import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        // we will store index and the height
        // the index will represent the backward idx it can be extended upto
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            // update area normally
            area = Math.max(area, heights[i]);
            if (st.isEmpty()) {
                // if its empty just push onto and continue
                st.push(new int[] { i, heights[i] });
                continue;
            }
            int lastPoppedIdx = -1;
            // if prev heights are greater
            while (!st.isEmpty() && heights[i] < st.peek()[1]) {
                // means stack top couldn't be extended forward
                lastPoppedIdx = st.peek()[0];
                // calculate the area it could have made
                area = Math.max(area, (i - st.peek()[0]) * st.peek()[1]);
                st.pop();
            }
            if (lastPoppedIdx != -1) {
                // add only if we popped previously
                // we knew it extended backwards
                st.push(new int[] { lastPoppedIdx, heights[i] });
            }
            // if prev heights are lesser or equal maybe
            if (heights[i] >= st.peek()[1]) {
                // then we push
                st.push(new int[] { i, heights[i] });
            }
        }
        printStack(st);
        // Now for the remaining elements in the stack,
        // we know they could be extend till the end from stored index
        // so we process remaining
        while (!st.isEmpty()) {
            int[] curr = st.pop();
            area = Math.max(area, curr[1] * (n - curr[0]));
            // System.out.println(curr[1] * (n - curr[0]));
        }
        return area;
    }

    private void printStack(Stack<int[]> st) {
        // Printing the remaining stack
        for (int i = 0; i < st.size(); i++) {
            System.out.println(Arrays.toString(st.get(i)));
        }
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(obj.largestRectangleArea(heights));
    }
}
