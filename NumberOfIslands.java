import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    countIslandsRecursiveHelper(grid, i, j, new HashSet<>());
                }
            }
        }
        return count;
    }

    private void countIslandsRecursiveHelper(char[][] grid, int row, int col, Set<List<Integer>> visited) {
        List<Integer> currRowCol = new ArrayList<>();
        currRowCol.add(row);
        currRowCol.add(col);
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || visited.contains(currRowCol)
                || grid[row][col] == '0') {
            return;
        }
        // Mark as Done once it is traversed
        grid[row][col] = 'D';
        visited.add(currRowCol);
        countIslandsRecursiveHelper(grid, row, col + 1, visited);
        countIslandsRecursiveHelper(grid, row + 1, col, visited);
        countIslandsRecursiveHelper(grid, row, col - 1, visited);
        countIslandsRecursiveHelper(grid, row - 1, col, visited);
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        NumberOfIslands obj = new NumberOfIslands();
        System.out.println(obj.numIslands(grid));
    }
}

// *** TIME LIMIT EXCEEDED SOLUTION I DID PREVIOUSLY USING PYTHON (USED
// BFS)***//
// class Solution(object):
// def numIslands(self, grid):
// visited = []
// islands = 0
// for i in range(0, len(grid)):
// for j in range(0, len(grid[0])):
// if grid[i][j] == "1" and [i, j] not in visited:
// visited.append([i, j])
// self.BFSInGrid(grid, visited, i, j)
// islands += 1

// return islands

// def BFSInGrid(self, grid, visited, i, j):
// queue = [[i, j]]

// while queue:
// first = queue.pop(0)
// allneighs = self.getNeighbors(first[0], first[1], grid)
// for item in allneighs:
// if item not in visited and grid[item[0]][item[1]] != "0":
// queue.append(item)
// visited.append(item)

// return visited

// def getNeighbors(self, row, col, graph):
// neighbors = []
// if (col + 1) <= len(graph[0]) - 1:
// neighbors.append([row, col + 1])
// if (col - 1) >= 0:
// neighbors.append([row, col - 1])
// if (row - 1) >= 0:
// neighbors.append([row - 1, col])
// if (row + 1) <= len(graph) - 1:
// neighbors.append([row + 1, col])
// return neighbors

// if __name__ == "__main__":
// grid = [
// ["1", "1", "1", "1", "0"],
// ["1", "1", "0", "1", "0"],
// ["1", "1", "0", "0", "0"],
// ["0", "0", "0", "0", "1"],
// ["0", "1", "1", "0", "0"],
// ["0", "0", "0", "1", "1"],
// ]
// ins = Solution()
// print(ins.numIslands(grid))
