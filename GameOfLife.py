class Solution(object):
    def gameOfLife(self, board):
        # DONOT RETURN ANYTHING : MODIFY THE ORIGINAL BOARD
        final = [[0 for i in range(0, len(board[0]))] for j in range(0, len(board))]

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                getNeighs = self.getAllNeighbors(i, j, board)
                if board[i][j] == 0 and sum(getNeighs) == 3:
                    final[i][j] = 1
                if board[i][j] == 1 and sum(getNeighs) < 2:
                    final[i][j] = 0
                if board[i][j] == 1 and sum(getNeighs) == 2 or sum(getNeighs) == 3:
                    final[i][j] = 1
                if board[i][j] == 1 and sum(getNeighs) > 3:
                    final[i][j] = 0

        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                board[i][j] = final[i][j]

    def getAllNeighbors(self, row, col, graph):
        neighbors = []
        if (col + 1) <= len(graph[0]) - 1:
            neighbors.append(graph[row][col + 1])
        if (col - 1) >= 0:
            neighbors.append(graph[row][col - 1])
        if (row - 1) >= 0:
            neighbors.append(graph[row - 1][col])
        if (row + 1) <= len(graph) - 1:
            neighbors.append(graph[row + 1][col])
        # FOR DIAGONAL NEIGHBOURS
        if (row - 1) >= 0 and (col - 1) >= 0:
            neighbors.append(graph[row - 1][col - 1])
        if (row - 1) >= 0 and (col + 1) <= len(graph[0]) - 1:
            neighbors.append(graph[row - 1][col + 1])
        if (row + 1) <= len(graph) - 1 and (col - 1) >= 0:
            neighbors.append(graph[row + 1][col - 1])
        if (row + 1) <= len(graph) - 1 and (col + 1) <= len(graph[0]) - 1:
            neighbors.append(graph[row + 1][col + 1])

        return neighbors


if __name__ == "__main__":
    board = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    # board = [[1, 1], [1, 0]]
    obj = Solution()
    print(obj.gameOfLife(board))
    print(board)
