package IslandPerimeter;

import java.util.ArrayList;
import java.util.List;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        List<List<Integer>> queue = new ArrayList<>();
        List<List<Integer>> visited = new ArrayList<>();
        queue.add(List.of(0, 0));
        visited.add(List.of(0, 0));
        if (grid[0][0] != 0) {
            List<List<Integer>> neighbs = getNeighbors(0, 0,
                    grid);
            int difference = 4 - neighbs.size();
            for (List<Integer> neighs : neighbs) {
                if (grid[neighs.get(0)][neighs.get(1)] == 0) {
                    perimeter += 1;
                }
            }
            perimeter += difference;
        }
        while (queue.size() > 0) {
            List<Integer> first = queue.remove(0);
            List<List<Integer>> neighbours = getNeighbors(first.get(0), first.get(1),
                    grid);
            for (List<Integer> item : neighbours) {
                if (visited.contains(item) == false) {
                    visited.add(item);
                    queue.add(item);
                    if (grid[item.get(0)][item.get(1)] != 0) {
                        List<List<Integer>> neighbs = getNeighbors(item.get(0), item.get(1), grid);
                        int difference = 4 - neighbs.size();
                        for (List<Integer> neighs : neighbs) {
                            if (grid[neighs.get(0)][neighs.get(1)] == 0) {
                                perimeter += 1;
                            }
                        }
                        perimeter += difference;
                    }
                }
            }
        }
        return perimeter;
    }

    private List<List<Integer>> getNeighbors(int row, int col, int[][] graph) {
        List<List<Integer>> neighbors = new ArrayList<>();

        if ((col + 1) <= graph[0].length - 1) {
            neighbors.add(List.of(row, col + 1));
        }
        if ((col - 1) >= 0) {
            neighbors.add(List.of(row, col - 1));
        }
        if ((row - 1) >= 0) {
            neighbors.add(List.of(row - 1, col));
        }
        if ((row + 1) <= graph.length - 1) {
            neighbors.add(List.of(row + 1, col));
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        // int[][] grid = { { 0, 0, 1 } };
        IslandPerimeter ip = new IslandPerimeter();
        System.out.println(ip.islandPerimeter(grid));
    }

}