package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        result.add(Arrays.asList(1, 0, 0));
        result.add(Arrays.asList(0, 0));

        return result;
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));

        System.out.println(arr.get(0)); // Accessing the first element of the list

    }
}
