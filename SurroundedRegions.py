class Solution(object):
    def solve(self, board):
        zeroesPos = self.getZeroesPos(board)

        for poss in zeroesPos:
            neighs = self.getNeighbors(poss[0], poss[1], board)
            if len(neighs) == 4:
                board[poss[0]][poss[1]] = "X"

        return board

    def getZeroesPos(self, board):
        zeroesPos = []
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == "O":
                    zeroesPos.append([i, j])
        return zeroesPos

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
    board = [
        ["X", "X", "X", "X"],
        ["X", "O", "O", "X"],
        ["X", "X", "O", "X"],
        ["X", "O", "X", "X"],
    ]
    board = [["X", "X", "X"], ["X", "O", "X"], ["X", "X", "X"]]
    # board = ["X"]
    # OUTPUT : [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    obj = Solution()
    print(obj.solve(board))
