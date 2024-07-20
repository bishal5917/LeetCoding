import java.util.Arrays;

public class NumberOfEmployeesWhoMetTheTarget {

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        // NORMAL SOLUTION O(n)
        // int count = 0;
        // for (int hour : hours) {
        // if (hour >= target) {
        // count++;
        // }
        // }
        // LETS TRY DOING THIS USING BINARY SEARCH
        // THIS IS EVEN WORSE SOLUTION SINCE ARRAY IS NOT SORTED ALREADY BY DEFAULT
        // THIS WILL TAKE O(nlogn)+O(logn)
        // JUST DOING FOR FUN
        int idx = -1;
        Arrays.sort(hours);
        int n = hours.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int hour = hours[mid];
            if (hour >= target) {
                // If curr one is greater or equal
                // we go left and try to find if we have another equal one
                r = mid - 1;
                // we track the index
                idx = mid;
            } else {
                // if curr one is lesser than target we go right
                l = mid + 1;
            }
        }
        // System.out.println(idx);
        return idx == -1 ? 0 : n - idx;
    }

    public static void main(String[] args) {
        NumberOfEmployeesWhoMetTheTarget obj = new NumberOfEmployeesWhoMetTheTarget();
        int[] hours = { 5, 1, 4, 2, 2 };
        int target = 6;
        System.out.println(obj.numberOfEmployeesWhoMetTarget(hours, target));
    }

}
