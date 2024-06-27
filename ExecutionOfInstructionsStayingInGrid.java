import java.util.Arrays;

public class ExecutionOfInstructionsStayingInGrid {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        // We try to go according to the instructions for each of them
        // and update the result
        for (int i = 0; i < s.length(); i++) {
            int r = startPos[0];
            int c = startPos[1];
            int count = 0;
            // we try to go and lets count how far can we go
            int idx = i;
            while (idx < s.length()) {
                char dir = s.charAt(idx);
                if (dir == 'R') {
                    c++;
                } else if (dir == 'L') {
                    c--;
                } else if (dir == 'D') {
                    r++;
                } else if (dir == 'U') {
                    r--;
                }
                if (r < n && c < n && r >= 0 && c >= 0 && idx < s.length()) {
                    idx++;
                    count++;
                } else {
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        ExecutionOfInstructionsStayingInGrid obj = new ExecutionOfInstructionsStayingInGrid();
        int n = 3;
        int[] startPos = { 0, 1 };
        String s = "RRDDLU";
        int[] ans = obj.executeInstructions(n, startPos, s);
        System.out.println(Arrays.toString(ans));
    }
}
