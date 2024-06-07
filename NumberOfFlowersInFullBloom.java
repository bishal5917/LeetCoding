import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfFlowersInFullBloom {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        // Lets just keep arrays of blooming and unblooming
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (int[] flower : flowers) {
            start.add(flower[0]);
            end.add(flower[1] + 1);
        }
        Collections.sort(start);
        Collections.sort(end);

        // Lets find bloomed and unbloomed time using binary search
        for (int i = 0; i < people.length; i++) {
            int a = binarySearch(start, people[i]);
            int b = binarySearch(end, people[i]);
            ans[i] = a - b;
        }
        return ans;
    }

    private int binarySearch(List<Integer> arr, int val) {
        int l = 0, r = arr.size() - 1, m = r;
        while (l <= r) {
            m = (l + (r - l) / 2);
            if (arr.get(m) > val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        NumberOfFlowersInFullBloom obj = new NumberOfFlowersInFullBloom();
        int[][] flowers = {
                { 1, 6 }, { 3, 7 }, { 9, 12 }, { 4, 13 }
        };
        int[] people = { 2, 3, 7, 11 };
        int[] ans = obj.fullBloomFlowers(flowers, people);
        System.out.println(Arrays.toString(ans));
    }
}
