import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateZeroes {

    public void duplicateZeros(int[] arr) {
        // BY USING EXTRA MEMORY
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (ans.size() == arr.length) {
                break;
            }
            if (arr[i] == 0) {
                ans.add(0);
                ans.add(0);
            } else {
                ans.add(arr[i]);
            }
        }
        // Now copy back to nums
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZerosOptimal(int[] arr) {
        // WITHOUT USING EXTRA SPACE - MODIFYING IN PLACE
        int i = 0;
        int continuousZeroesCase = 0;
        while (i < arr.length) {
            if (arr[i] != 0) {
                i += 1;
                continue;
            }
            if (i - 1 >= 0 && i - 2 >= 0 && arr[i - 1] == 0 && arr[i - 2] == 0) {
                // means previous two zeroes
                continuousZeroesCase += 1;
            }
            // if zero , then add another zero and shift the array
            int j = arr.length - 1;
            while (j > i + 1) {
                arr[j] = arr[j - 1];
                j -= 1;
            }
            if (i + 1 < arr.length) {
                arr[i + 1] = 0;
                i += 2;
                // after adding zero we gotta increment by 2
            }
            if (continuousZeroesCase > 10) {
                break;
            }
            // System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        DuplicateZeroes obj = new DuplicateZeroes();
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
        // obj.duplicateZeros(arr);
        obj.duplicateZerosOptimal(arr);
    }
}
