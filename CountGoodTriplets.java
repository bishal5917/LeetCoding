import java.util.List;

public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int triplets = 0;
        int n = arr.length;
        // Gotta use triple loops
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int diffA = Math.abs(arr[i] - arr[j]);
                    int diffB = Math.abs(arr[j] - arr[k]);
                    int diffC = Math.abs(arr[i] - arr[k]);
                    if (diffA <= a && diffB <= b && diffC <= c) {
                        // System.out.println(curr);
                        triplets++;
                    }
                }
            }
        }
        // return recursiveHelper(arr, a, b, c, 0, new ArrayList<>(), triplets);
        return triplets;
    }

    // TIME LIMIT EXCEEDED
    // Lets do this using recursive backtracking approach (TOTAL BRUTEFORCE)
    private int recursiveHelper(int[] arr, int a, int b, int c, int idx, List<Integer> curr, int count) {
        if (curr.size() == 3) {
            int diffA = Math.abs(curr.get(0) - curr.get(1));
            int diffB = Math.abs(curr.get(1) - curr.get(2));
            int diffC = Math.abs(curr.get(0) - curr.get(2));
            // checking if that triplet is good
            if (diffA <= a && diffB <= b && diffC <= c) {
                // System.out.println(curr);
                count++;
            }
        }
        for (int i = idx; i < arr.length; i++) {
            curr.add(arr[i]);
            count = recursiveHelper(arr, a, b, c, i + 1, curr, count);
            curr.remove(curr.size() - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountGoodTriplets obj = new CountGoodTriplets();
        int[] arr = { 44, 11, 10, 35, 42, 39, 0, 5, 40, 6, 18, 18, 8, 41, 12, 46, 13, 11, 21, 37, 5, 33, 41, 33, 7,
                46 };
        int a = 22;
        int b = 6;
        int c = 13;
        System.out.println(obj.countGoodTriplets(arr, a, b, c));
    }
}
