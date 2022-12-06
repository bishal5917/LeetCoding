def BFSInGrid(grid):

    visited = [[0, 0]]
    queue = [[0, 0]]

    while queue:
        first = queue.pop(0)
        allneighs = getNeighbors(first[0], first[1], grid)
        for item in allneighs:
            if item not in visited and grid[item[0]][item[1]] != "0":
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
    grid = [
        ["1", "1", "1", "1", "0"],
        ["1", "1", "0", "1", "0"],
        ["1", "1", "0", "0", "0"],
        ["0", "0", "0", "0", "0"],
    ]
    print(BFSInGrid(grid))
