import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        // start could also be a deadend
        if (deads.contains("0000")) {
            return -1;
        }
        return bfsHelper(deads, target);
    }

    private int bfsHelper(HashSet<String> deadends, String target) {
        int turns = 0;
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        // Now starting BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return turns;
                }
                // Now rotate and check wheels
                for (int x = 0; x < 4; x++) {
                    // Note : fc=front combination && bc=back combination
                    StringBuilder fc = new StringBuilder(curr);
                    fc.setCharAt(x, curr.charAt(x) == '9' ? '0' : (char) (curr.charAt(x) + 1));
                    StringBuilder bc = new StringBuilder(curr);
                    bc.setCharAt(x, curr.charAt(x) == '0' ? '9' : (char) (curr.charAt(x) - 1));
                    // Now add to queue and visited
                    if (!deadends.contains(fc.toString()) && !visited.contains(fc.toString())) {
                        queue.offer(fc.toString());
                        visited.add(fc.toString());
                    }
                    if (!deadends.contains(bc.toString()) && !visited.contains(bc.toString())) {
                        queue.offer(bc.toString());
                        visited.add(bc.toString());
                    }
                }
            }
            turns += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock obj = new OpenTheLock();
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        System.out.println(obj.openLock(deadends, target));
    }
}
