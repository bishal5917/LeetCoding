class Solution(object):
    def solve(self, board):
        borders = self.getBorders(board)
        for item in borders:
            if board[item[0]][item[1]] == "O":
                board[item[0]][item[1]] = "T"

        visited = []

        for item in borders:
            if board[item[0]][item[1]] == "T" and [item[0], item[1]] not in visited:
                visited.append([item[0], item[1]])
                self.BFSInGrid(board, visited, item[0], item[1])

        for item in visited:
            if board[item[0]][item[1]] == "O":
                board[item[0]][item[1]] = "T"

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == "O":
                    board[i][j] = "X"

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == "T":
                    board[i][j] = "O"
        return board

    def BFSInGrid(self, grid, visited, i, j):
        queue = [[i, j]]

        while queue:
            first = queue.pop(0)
            allneighs = self.getNeighbors(first[0], first[1], grid)
            for item in allneighs:
                if item not in visited and grid[item[0]][item[1]] == "O":
                    visited.append(item)
                    queue.append(item)

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

    def getBorders(self, board):
        sr = 0
        sc = 0
        er = len(board) - 1
        ec = len(board[0]) - 1
        borders = []

        for i in range(sc, ec + 1):
            borders.append([sr, i])
        for i in range(sr + 1, er + 1):
            borders.append([i, ec])
        for i in reversed(range(sc, ec)):
            borders.append([er, i])
        for i in reversed(range(sr + 1, er)):
            borders.append([i, sr])

        return borders


if __name__ == "__main__":
    board = [
        ["X", "X", "X", "X"],
        ["X", "O", "O", "X"],
        ["X", "X", "O", "X"],
        ["X", "O", "X", "X"],
    ]

    # board = [["O", "O", "O"], ["O", "O", "O"], ["O", "O", "O"]]
    obj = Solution()
    print(obj.solve(board))
