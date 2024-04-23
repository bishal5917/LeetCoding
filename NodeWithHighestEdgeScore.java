import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NodeWithHighestEdgeScore {

    public int edgeScore(int[] edges) {
        long currMaxScore = 0;
        int highestScoreNode = 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // We have to track the incomings
        for (int i = 0; i < edges.length; i++) {
            int pointsTo = edges[i];
            if (graph.containsKey(pointsTo)) {
                List<Integer> nebs = graph.get(pointsTo);
                nebs.add(i);
                graph.put(pointsTo, nebs);
            } else {
                List<Integer> nebs = new ArrayList<>();
                nebs.add(i);
                graph.put(pointsTo, nebs);
            }
        }
        System.out.println(graph);
        // Now go through every nodes and check the max score
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            long currScore = 0;
            List<Integer> nebs = entry.getValue();
            for (long item : nebs) {
                currScore += item;
            }
            if (currScore > currMaxScore) {
                currMaxScore = currScore;
                highestScoreNode = entry.getKey();
            } else if (currScore == currMaxScore) {
                highestScoreNode = Math.min(highestScoreNode, entry.getKey());
            }
        }
        return highestScoreNode;
    }

    public static void main(String[] args) {
        NodeWithHighestEdgeScore obj = new NodeWithHighestEdgeScore();
        int[] edges = { 1, 0, 0, 0, 0, 7, 7, 5 };
        System.out.println(obj.edgeScore(edges));
    }
}
