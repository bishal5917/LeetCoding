import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = bfsHelper(n, k);
        // Now generate the required answer
        int[] nums = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            nums[i] = ans.get(i);
        }
        return nums;
    }

    private List<Integer> bfsHelper(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)));
        while (n > 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currNum = queue.poll();
                // Take the last number and check
                int last = currNum % 10;
                StringBuilder currStrNum = new StringBuilder(String.valueOf(currNum));
                for (int x = 0; x <= 9; x++) {
                    if (Math.abs(last - x) == k) {
                        currStrNum.append(x);
                        queue.offer(Integer.valueOf(currStrNum.toString()));
                        currStrNum.deleteCharAt(currStrNum.length() - 1);
                    }
                }
            }
            n -= 1;
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences obj = new NumbersWithSameConsecutiveDifferences();
        int n = 2;
        int k = 1;
        int[] ans = obj.numsSameConsecDiff(n, k);
        System.out.println(Arrays.toString(ans));
    }
}
