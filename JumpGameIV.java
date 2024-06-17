import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpGameIV {

    public int minJumps(int[] arr) {
        // Lets first count the occuring indexes of number
        HashMap<Integer, List<Integer>> idxs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idxs.putIfAbsent(arr[i], new ArrayList<>());
            idxs.get(arr[i]).add(i);
        }
        System.out.println(idxs);
        return bfsHelper(arr, idxs);
    }

    private int bfsHelper(int[] arr, HashMap<Integer, List<Integer>> idxs) {
        int n = arr.length;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int idx = q.poll();
                if (idx == n - 1) {
                    return count;
                }
                // else we go for right,left and same occurings idxs
                if (idx + 1 < n && !visited.contains(idx + 1)) {
                    if (idx + 1 == n - 1) {
                        return count + 1;
                    }
                    q.offer(idx + 1);
                    visited.add(idx + 1);
                }
                // else we go for right,left and same occurings idxs
                if (idx - 1 >= 0 && !visited.contains(idx - 1)) {
                    if (idx - 1 == n - 1) {
                        return count;
                    }
                    q.offer(idx - 1);
                    visited.add(idx - 1);
                }
                if (idxs.containsKey(arr[idx])) {
                    for (int index : idxs.get(arr[idx])) {
                        if (index == n - 1) {
                            return count + 1;
                        }
                        if (visited.contains(index) || index == idx) {
                            continue;
                        }
                        q.offer(index);
                        visited.add(index);
                    }
                    idxs.remove(arr[idx]);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        JumpGameIV obj = new JumpGameIV();
        int[] arr = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
        System.out.println(obj.minJumps(arr));
    }
}
