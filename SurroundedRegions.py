class Solution(object):
    def solve(self, board):
        zeroesPos = self.getZeroesPos(board)

        for poss in zeroesPos:
            neighs = self.getNeighbors(poss[0], poss[1], board)
            if len(neighs) == 4 and self.checkValidToALter(neighs, board):
                board[poss[0]][poss[1]] = "X"

        return board

    def checkValidToALter(self, neighs, board):
        borders = self.getBorders(board)
        zeroesPos = self.getZeroesPos(board)
        for item in neighs:
            if item in borders and item in zeroesPos:
                return False

        return True

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
        ["O", "X", "X", "O", "X"],
        ["X", "O", "O", "X", "O"],
        ["X", "O", "X", "O", "X"],
        ["O", "X", "O", "O", "O"],
        ["X", "X", "O", "X", "O"],
    ]
    # output = [
    #     ["O", "X", "X", "O", "X"],
    #     ["X", "X", "X", "X", "O"],
    #     ["X", "X", "X", "O", "X"],
    #     ["O", "X", "O", "O", "O"],
    #     ["X", "X", "O", "X", "O"],
    # ]
    obj = Solution()
    print(obj.solve(board))
    # print(obj.getBorders(board))
