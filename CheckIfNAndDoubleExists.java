import java.util.HashMap;

public class CheckIfNAndDoubleExists {

    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> halves = new HashMap<>();
        // lets store all the halves
        for (int num : arr) {
            if (!halves.containsKey(num * 2)) {
                halves.put(num * 2, 1);
            } else {
                halves.put(num * 2, halves.get(num * 2) + 1);
            }
        }
        System.out.println(halves);
        for (int num : arr) {
            if (num != 0) {
                if (halves.containsKey(num)) {
                    return true;
                }
            } else {
                // handling for double zero cases
                if (halves.get(num) > 1) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfNAndDoubleExists obj = new CheckIfNAndDoubleExists();
        int[] arr = { 2, 10, 5, 3 };
        System.out.println(obj.checkIfExist(arr));
    }

}
