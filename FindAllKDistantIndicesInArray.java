import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllKDistantIndicesInArray {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        List<Integer> keyOccurences = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyOccurences.add(i);
            }
        }
        // Now go on and check if given condition meets
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < keyOccurences.size(); j++) {
                if (Math.abs(i - keyOccurences.get(j)) <= k) {
                    indices.add(i);
                    break;
                }
            }
        }
        Collections.sort(indices);
        return indices;
    }

    public static void main(String[] args) {
        FindAllKDistantIndicesInArray obj = new FindAllKDistantIndicesInArray();
        int[] nums = { 3, 4, 9, 1, 3, 9, 5 };
        System.out.println(obj.findKDistantIndices(nums, 9, 1));
    }
}
