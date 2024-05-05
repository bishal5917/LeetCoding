import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Emp {
    int id;
    int time;

    public Emp(int id, int time) {
        this.id = id;
        this.time = time;
    }
}

public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // Lets create a graph first
        HashMap<Integer, List<Emp>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            graph.putIfAbsent(manager[i], new ArrayList<>());
            graph.get(manager[i]).add(new Emp(i, informTime[i]));
        }
        System.out.println(graph);
        Emp head = new Emp(headID, informTime[headID]);
        return dfsHelper(graph, 0, head);
    }

    // lets perform a dfs on the root node
    private int dfsHelper(HashMap<Integer, List<Emp>> graph, int time, Emp curr) {
        if (graph.get(curr.id) == null) {
            time = Math.max(curr.time, time);
            return time;
        }
        // Now go for its neighbors
        for (Emp ch : graph.get(curr.id)) {
            ch.time = curr.time + ch.time;
            time = dfsHelper(graph, time, ch);
        }
        return time;
    }

    public static void main(String[] args) {
        TimeNeededToInformAllEmployees obj = new TimeNeededToInformAllEmployees();
        int n = 6;
        int headID = 2;
        int[] manager = { 2, 2, -1, 2, 2, 2 };
        int[] informTime = { 0, 0, 1, 0, 0, 0 };
        System.out.println(obj.numOfMinutes(n, headID, manager, informTime));
    }
}
