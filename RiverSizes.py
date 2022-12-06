# A classic Graph Traversal Question
def riverSizes(matrix):
    visited = []
    Rivers = []

    for i in range(0, len(matrix)):
        for j in range(0, len(matrix[0])):
            if matrix[i][j] == 1 and [i, j] not in visited:
                visited.append([i, j])
                BFSInGrid(matrix, visited, i, j)
                lenVisited = len(visited)
                Rivers.append(lenVisited - sum(Rivers))

    return Rivers


def BFSInGrid(grid, visited, i, j):
    queue = [[i, j]]
    while queue:
        first = queue.pop(0)
        allneighs = getNeighbors(first[0], first[1], grid)
        for item in allneighs:
            if item not in visited and grid[item[0]][item[1]] != 0:
                queue.append(item)
                visited.append(item)

    return visited


def getNeighbors(row, col, graph):
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
    graph = [
        [1, 0, 0, 1, 0],
        [1, 0, 1, 0, 0],
        [0, 0, 1, 0, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 0],
    ]
    print(riverSizes(graph))
