import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class DivNode {
    String val;
    double cost;

    public DivNode(String val, double cost) {
        this.val = val;
        this.cost = cost;
    }
}

public class EvaluateDivision {

    boolean isFound = false;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answers = new double[queries.size()];
        // Lets first create an adjacency list first
        HashMap<String, List<DivNode>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double cost = values[i];
            String from = equation.get(0);
            String to = equation.get(1);
            // add to the map,if collision,make a list
            DivNode newOneForward = new DivNode(to, cost);
            DivNode newOneBackward = new DivNode(from, 1 / cost);
            // FOR FORWARD
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(newOneForward);
            // FOR BACKWARD
            graph.putIfAbsent(to, new ArrayList<>());
            graph.get(to).add(newOneBackward);
        }
        // NOW TIME TO PERFORM BFS FOR EACH QUERIES
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            // perform dfs and get the answer
            isFound = false;
            double prod = getProductDfsHelper(graph, new HashSet<>(), 1, new DivNode(start, 1), end);
            if (isFound) {
                answers[i] = prod;
            } else {
                // if exited without reaching,put -1
                answers[i] = -1;
            }
        }
        return answers;
    }

    private double getProductDfsHelper(HashMap<String, List<DivNode>> graph, HashSet<String> visited, double prod,
            DivNode curr, String d) {
        if (!graph.containsKey(curr.val)) {
            return prod;
        }
        if (curr.val.equals(d)) {
            // destination found
            isFound = true;
            return prod;
        }
        visited.add(curr.val);
        // go for all of the pairs
        for (DivNode neighbor : graph.get(curr.val)) {
            if (!visited.contains(neighbor.val)) {
                prod = prod * neighbor.cost;
                visited.add(neighbor.val);
                prod = getProductDfsHelper(graph, visited, prod, neighbor, d);
                if (isFound) {
                    // exit early if destination reached
                    return prod;
                }
                // backtrack
                prod = prod / neighbor.cost;
            }
        }
        return prod;
    }

    public static void main(String[] args) {
        EvaluateDivision obj = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        double[] values = { 2.0, 3.0 };
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));
        double[] ans = obj.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }
}
