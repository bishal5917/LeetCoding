import java.util.Arrays;
import java.util.Stack;

public class NumberOfVisiblePeopleInQueue {

    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] sees = new int[n];
        Stack<Integer> st = new Stack<>();
        // We go from right to the left
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] > st.peek()) {
                // then increase the count and pop
                sees[i] += 1;
                st.pop();
            }
            if (!st.isEmpty()) {
                // if its not empty and prev condition didn't match
                // if can see the one next greater
                sees[i] += 1;
            }
            st.push(heights[i]);
        }
        return sees;
    }

    public static void main(String[] args) {
        NumberOfVisiblePeopleInQueue obj = new NumberOfVisiblePeopleInQueue();
        int[] heights = { 10, 6, 8, 5, 11, 9 };
        int[] ans = obj.canSeePersonsCount(heights);
        System.out.println(Arrays.toString(ans));
    }
}
