import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Lets create a graph first
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meet : meetings) {
            int a = meet[0];
            int b = meet[1];
            int t = meet[2];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new int[] { b, t });
            graph.get(b).add(new int[] { a, t });
        }
        return bfsHelper(graph, n, firstPerson);
    }

    private List<Integer> bfsHelper(HashMap<Integer, List<int[]>> g, int n, int f) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);
        pq.offer(new int[] { 0, 0 });
        pq.offer(new int[] { f, 0 });
        // Now we do bfs
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            // Now time to go for its neighbors
            if (!g.containsKey(node)) {
                continue;
            }
            for (int[] neb : g.get(node)) {
                // we add only if the next time is greater
                // only if current has been informed already
                if (!visited[neb[0]] && time <= neb[1]) {
                    pq.offer(neb);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAllPeopleWithSecret obj = new FindAllPeopleWithSecret();
        int n = 6;
        int[][] meetings = { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } };
        int firstPerson = 1;
        System.out.println(obj.findAllPeople(n, meetings, firstPerson));
    }
}
