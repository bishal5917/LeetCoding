import java.util.HashSet;

public class CheckIfAllIntegersAreCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        // Lets just make a hashset and put all integers
        HashSet<Integer> set = new HashSet<>();
        for (int[] range : ranges) {
            int start = range[0];
            int end = range[1];
            for (int i = start; i <= end; i++) {
                set.add(i);
            }
        }
        // Now check if every val from left to right is covered
        for (int i = left; i <= right; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        System.out.println(set);
        return true;
    }

    public static void main(String[] args) {
        CheckIfAllIntegersAreCovered obj = new CheckIfAllIntegersAreCovered();
        int[][] ranges = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int left = 2;
        int right = 5;
        System.out.println(obj.isCovered(ranges, left, right));
    }
}
