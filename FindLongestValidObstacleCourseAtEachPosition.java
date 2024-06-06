import java.util.Arrays;

public class FindLongestValidObstacleCourseAtEachPosition {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] ans = new int[n];
        int[] mono = new int[n];
        // Lets go and create a monotonic array
        // while maintaining the count
        // means top of the stack
        int top = -1;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int curr = obstacles[i];
            if (top == -1 || (top >= 0 && curr >= mono[top])) {
                // means increasing subsequence happening
                // just go forward
                mono[++top] = curr;
                len++;
                // update the answer
                ans[i] = len;
            } else {
                // else if we find a decreasing number
                // we find the first number that is just greater than curr
                // and we replace it
                // We use binary search
                int l = 0, r = top, mid;
                while (l < r) {
                    mid = (l + (r - l) / 2);
                    if (mono[mid] > curr) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                // means till right,we will have increasing subsequence
                mono[r] = curr;
                ans[i] = r + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLongestValidObstacleCourseAtEachPosition obj = new FindLongestValidObstacleCourseAtEachPosition();
        int[] obstacles = { 1, 2, 3, 1, 2, 3 };
        int[] ans = obj.longestObstacleCourseAtEachPosition(obstacles);
        System.out.println(Arrays.toString(ans));
    }
}
