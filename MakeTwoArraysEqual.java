import java.util.Arrays;

public class MakeTwoArraysEqual {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        int idx = 0;
        while (idx < arr.length) {
            if (arr[idx] != target[idx]) {
                return false;
            }
            idx += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int[] target = { 2, 4, 1, 3 };
        MakeTwoArraysEqual obj = new MakeTwoArraysEqual();
        System.out.println(obj.canBeEqual(target, arr));
    }

}
