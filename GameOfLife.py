class Solution(object):
    def gameOfLife(self, board):
        neighs = self.getNeighbors(1, 0, board)
        print(neighs)

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
        # FOR DIAGONAL NEIGHBOURS
        if (row - 1) >= 0 and (col - 1) >= 0:
            neighbors.append([row - 1, col - 1])
        if (row - 1) >= 0 and (col + 1) <= len(graph[0]) - 1:
            neighbors.append([row - 1, col + 1])
        if (row + 1) <= len(graph) - 1 and (col - 1) >= 0:
            neighbors.append([row + 1, col - 1])
        if (row + 1) <= len(graph) - 1 and (col + 1) <= len(graph[0]) - 1:
            neighbors.append([row + 1, col + 1])

        return neighbors


if __name__ == "__main__":
    graph = [[0, 1, 0], [0, 0, 1], [1, 1, 1], [0, 0, 0]]
    obj = Solution()
    print(obj.gameOfLife(graph))
