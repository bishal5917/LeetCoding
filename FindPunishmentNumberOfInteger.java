import java.util.ArrayList;
import java.util.List;

public class FindPunishmentNumberOfInteger {

    boolean isFound = false;
    int currSum = 0;

    public int punishmentNumber(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            isFound = false;
            currSum = 0;
            getPunishmentNumberHelper(String.valueOf(i * i), new ArrayList<>(), 0, i);
            if (isFound)
                count += i * i;
        }
        return count;
    }

    private List<Integer> getPunishmentNumberHelper(String str, List<Integer> curr, int st, int num) {
        if (isFound == true) {
            return curr;
        }
        if (st >= str.length()) {
            // means one swoop done,check the sum
            if (currSum == num) {
                isFound = true;
            }
            return curr;
        }
        for (int i = 1; i <= str.length(); i++) {
            if ((st + i) > str.length()) {
                continue;
            }
            int val = Integer.valueOf(str.substring(st, st + i));
            curr.add(val);
            currSum += val;
            curr = getPunishmentNumberHelper(str, curr, st + i, num);
            int last = curr.get(curr.size() - 1);
            curr.remove(curr.size() - 1);
            currSum -= last;
        }
        return curr;
    }

    // private int getSum(List<Integer> arr) {
    // int num = 0;
    // for (int item : arr) {
    // num += item;
    // }
    // return num;
    // }

    public static void main(String[] args) {
        FindPunishmentNumberOfInteger obj = new FindPunishmentNumberOfInteger();
        int n = 10;
        System.out.println(obj.punishmentNumber(n));
    }
}
