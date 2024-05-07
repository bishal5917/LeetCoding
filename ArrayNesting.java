import java.util.HashSet;

public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        // Lets first do dfs for every nums,no matter what,just try
        int currMaxSize = 0;
        // Lets keep track of the visited array
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int len = dfsHelper(nums, visited, new HashSet<>(), i);
                currMaxSize = Math.max(currMaxSize, len);
            }
        }
        return currMaxSize;
    }

    private int dfsHelper(int[] nums, boolean[] visited, HashSet<Integer> currSet, int curr) {
        if (currSet.contains(curr) || visited[curr]) {
            // System.out.println(currSet);
            return currSet.size();
        }
        currSet.add(curr);
        visited[curr] = true;
        return dfsHelper(nums, visited, currSet, nums[curr]);
    }

    public static void main(String[] args) {
        ArrayNesting obj = new ArrayNesting();
        int[] nums = { 5, 4, 0, 3, 1, 6, 2 };
        System.out.println(obj.arrayNesting(nums));
    }
}
