class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        visited = []
        islands = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == "1" and [i, j] not in visited:
                    visited.append([i, j])
                    self.BFSInGrid(grid, visited, i, j)
                    islands += 1

        return islands

    def BFSInGrid(self, grid, visited, i, j):
        queue = [[i, j]]

        while queue:
            first = queue.pop(0)
            allneighs = self.getNeighbors(first[0], first[1], grid)
            for item in allneighs:
                if item not in visited and grid[item[0]][item[1]] != "0":
                    queue.append(item)
                    visited.append(item)

        return visited

    def getNeighbors(self, row, col, graph):
        neighbors = []
        if (col + 1) <= len(graph[0]) - 1:
            neighbors.append([row, col + 1])
        if (col - 1) >= 0:
            neighbors.append([row, col - 1])
        if (row - 1) >= 0:
            neighbors.append([row - 1, col])
        if (row + 1) <= len(graph) - 1:
            neighbors.append([row + 1, col])
        return neighbors


if __name__ == "__main__":
    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "1"],
        ["0", "1", "1", "0", "0"],
        ["0", "0", "0", "1", "1"],
    ]
    # grid = [
    #     ["1", "0", "0", "1", "0"],
    #     ["1", "0", "1", "0", "0"],
    #     ["0", "0", "1", "0", "1"],
    #     ["1", "0", "1", "0", "1"],
    #     ["1", "0", "1", "1", "0"],
    # ]
    ins = Solution()
    print(ins.numIslands(grid))
