import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colorOfStartingPixel = image[sr][sc];
        List<List<Integer>> visited = new ArrayList<>(Arrays.asList(Arrays.asList(sr, sc)));
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> firstOne = new ArrayList<>();
        firstOne.add(sr);
        firstOne.add(sc);
        queue.offer(firstOne);
        while (!queue.isEmpty()) {
            List<Integer> first = queue.poll();
            // get neighbours of first
            List<List<Integer>> neighbors = getNeighbors(first.get(0), first.get(1), image);
            for (List<Integer> neighbor : neighbors) {
                if (!visited.contains(neighbor) && image[neighbor.get(0)][neighbor.get(1)] == colorOfStartingPixel) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        System.out.println(visited);
        // substitute corresponding color to the original image
        for (List<Integer> item : visited) {
            int row = item.get(0);
            int col = item.get(1);
            image[row][col] = color;
        }
        return image;
    }

    public List<List<Integer>> getNeighbors(int row, int col, int[][] graph) {
        List<List<Integer>> neighbors = new ArrayList<>();
        if ((col + 1) <= graph[0].length - 1) {
            List<Integer> neighbor = new ArrayList<>();
            neighbor.add(row);
            neighbor.add(col + 1);
            neighbors.add(neighbor);
        }

        if ((col - 1) >= 0) {
            List<Integer> neighbor = new ArrayList<>();
            neighbor.add(row);
            neighbor.add(col - 1);
            neighbors.add(neighbor);
        }

        if ((row - 1) >= 0) {
            List<Integer> neighbor = new ArrayList<>();
            neighbor.add(row - 1);
            neighbor.add(col);
            neighbors.add(neighbor);
        }

        if ((row + 1) <= graph.length - 1) {
            List<Integer> neighbor = new ArrayList<>();
            neighbor.add(row + 1);
            neighbor.add(col);
            neighbors.add(neighbor);
        }

        return neighbors;
    }

    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 1;
        obj.floodFill(image, sr, sc, color);
    }

}
