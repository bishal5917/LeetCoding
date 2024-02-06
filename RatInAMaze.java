
// A CLASSIC BACKTRACKING PROBLEM
import java.util.ArrayList;
import java.util.List;

//Rat wants to go from the top left cell to the bottom right cell
//Rat has only two directions to move (RIGHT OR DOWN)
public class RatInAMaze {

    public List<String> findDirections(int[][] maze) {
        List<List<String>> paths = findMazeHelper(maze, 0, 0, new ArrayList<>(), new ArrayList<>());
        if (paths.size() == 0) {
            return new ArrayList<>();
        } else {
            return paths.get(0);
        }
    }

    public List<List<String>> findMazeHelper(int[][] maze, int row, int col, List<String> paths,
            List<List<String>> allPaths) {
        if (row >= maze.length || col >= maze[0].length || maze[row][col] == 0) {
            return allPaths;
        }
        // Means we have found the end
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            allPaths.add(new ArrayList<>(paths));
            System.out.println(paths);
            return allPaths;
        }
        // Moving right
        paths.add("R");
        findMazeHelper(maze, row, col + 1, paths, allPaths);
        // Remove that path if not possible (BACKTRACK)
        paths.remove(paths.size() - 1);
        // Moving down
        paths.add("D");
        findMazeHelper(maze, row + 1, col, paths, allPaths);
        // Remove that path if not possible (BACKTRACK)
        paths.remove(paths.size() - 1);
        return allPaths;
    }

    public static void main(String[] args) {
        RatInAMaze obj = new RatInAMaze();
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };
        List<String> ans = obj.findDirections(maze);
        System.out.println(ans);
    }
}
