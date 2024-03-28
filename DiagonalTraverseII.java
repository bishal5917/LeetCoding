import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class DiagonalTraverseII {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        // Lets do this using BFS Approach
        List<Integer> order = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        queue.offer(Arrays.asList(0, 0));
        visited.add(Arrays.asList(0, 0));
        // Now keep polling from the queue and add the value
        while (!queue.isEmpty()) {
            List<Integer> coordinate = queue.poll();
            int row = coordinate.get(0);
            int col = coordinate.get(1);
            order.add(nums.get(row).get(col));
            // now add the bottom and right
            if (col == 0 && row + 1 < nums.size() && !visited.contains(Arrays.asList(row + 1, col))) {
                queue.offer(Arrays.asList(row + 1, col));
                visited.add(Arrays.asList(row + 1, col));
            }
            if (col + 1 < nums.get(row).size() && !visited.contains(Arrays.asList(row, col + 1))) {
                queue.offer(Arrays.asList(row, col + 1));
                visited.add(Arrays.asList(row, col + 1));
            }
        }
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        DiagonalTraverseII obj = new DiagonalTraverseII();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3));
        nums.add(Arrays.asList(4, 5, 6));
        nums.add(Arrays.asList(7, 8, 9));
        int[] ans = obj.findDiagonalOrder(nums);
        System.out.println(Arrays.toString(ans));
    }
}
