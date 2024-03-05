import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> kVals = new ArrayList<>();
        // Now let's first sort the array through pancake sorting
        int sortedCount = arr.length - 1;
        // start pancake sorting
        // get the maxIdx and keep flipping
        while (sortedCount >= 0) {
            // first find the maxIndex
            int maxIdx = findMaxIdx(arr, sortedCount);
            flipAndSwap(arr, maxIdx, sortedCount);
            kVals.add(maxIdx + 1);
            // Now flip the array based on maxIdx and increment sortedCount
            sortedCount -= 1;
            // lets see after each flips
            System.out.println(Arrays.toString(arr));
        }
        return kVals;
    }

    private void flipAndSwap(int[] arr, int maxIdx, int sortedCount) {
        // Now flip from that maxIndexToTheFront
        while (maxIdx > 0) {
            swap(arr, maxIdx - 1, maxIdx);
            maxIdx -= 1;
        }
        // Now swap with the last
        swap(arr, 0, sortedCount);
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int findMaxIdx(int[] arr, int sortedCount) {
        int currMaxVal = Integer.MIN_VALUE;
        int currMaxIdx = -1;
        for (int i = 0; i <= sortedCount; i++) {
            if (arr[i] > currMaxVal) {
                currMaxVal = arr[i];
                currMaxIdx = i;
            }
        }
        return currMaxIdx;
    }

    public static void main(String[] args) {
        PancakeSorting obj = new PancakeSorting();
        int[] arr = { 3, 2, 4, 1 };
        System.out.println(obj.pancakeSort(arr));
    }
}
