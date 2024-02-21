import java.util.HashMap;

public class KthDistinctString {

    public String kthDistinct(String[] arr, int k) {
        // Lets just create a hashmap
        HashMap<String, Integer> bucket = new HashMap<>();
        for (String str : arr) {
            if (bucket.get(str) == null) {
                bucket.put(str, 1);
            } else {
                bucket.put(str, bucket.get(str) + 1);
            }
        }
        int count = 1;
        // Now check for that k
        for (String str : arr) {
            if (bucket.get(str) == 1 && count == k) {
                // means distinct
                return str;
            } else if (bucket.get(str) == 1 && count < k) {
                count += 1;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        KthDistinctString obj = new KthDistinctString();
        System.out.println(obj.kthDistinct(arr, 2));
    }

}
