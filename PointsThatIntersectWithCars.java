import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PointsThatIntersectWithCars {

    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> points = new HashSet<>();
        // Lets just use a double for loop
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                points.add(i);
            }
        }
        return points.size();
    }

    public static void main(String[] args) {
        PointsThatIntersectWithCars obj = new PointsThatIntersectWithCars();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(2, 5));
        nums.add(Arrays.asList(3, 8));
        nums.add(Arrays.asList(1, 6));
        nums.add(Arrays.asList(4, 10));
        System.out.println(obj.numberOfPoints(nums));
    }
}
