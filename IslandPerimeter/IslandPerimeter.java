package IslandPerimeter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IslandPerimeter {

    // More optimal DFS solution
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return findIslandPerimeterHelper(grid, i, j, 0);
                }
            }
        }
        return 0;
    }

    private int findIslandPerimeterHelper(int[][] grid, int row, int col, int perimeter) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            // means we reached the limit
            perimeter += 1;
            return perimeter;
        }
        // If we encounter already visited one,just return, dont add the perimter
        if (grid[row][col] == -1) {
            return perimeter;
        }
        // Mark traversed as visited
        grid[row][col] = -1;

        // traverse all directions
        // GO RIGHT
        perimeter = findIslandPerimeterHelper(grid, row + 1, col, perimeter);
        // GO DOWN
        perimeter = findIslandPerimeterHelper(grid, row, col + 1, perimeter);
        // GO LEFT
        perimeter = findIslandPerimeterHelper(grid, row, col - 1, perimeter);
        // GO UP
        perimeter = findIslandPerimeterHelper(grid, row - 1, col, perimeter);
        return perimeter;
    }

    // BFS solution that dosnot work for large input (LESS OPTIMAL)
    public int islandPerimeter2(int[][] grid) {
        int perimeter = 0;
        List<List<Integer>> queue = new ArrayList<>();
        List<List<Integer>> visited = new ArrayList<>();
        queue.add(Arrays.asList(0, 0));
        visited.add(Arrays.asList(0, 0));
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
            neighbors.add(Arrays.asList(row, col + 1));
        }
        if ((col - 1) >= 0) {
            neighbors.add(Arrays.asList(row, col - 1));
        }
        if ((row - 1) >= 0) {
            neighbors.add(Arrays.asList(row - 1, col));
        }
        if ((row + 1) <= graph.length - 1) {
            neighbors.add(Arrays.asList(row + 1, col));
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        // int[][] grid = { { 0, 0, 1 } };
        IslandPerimeter ip = new IslandPerimeter();
        System.out.println(ip.islandPerimeter(grid));
        System.out.println(ip.islandPerimeter2(grid));
    }

}