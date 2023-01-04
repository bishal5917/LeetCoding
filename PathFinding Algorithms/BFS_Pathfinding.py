def BFSInGrid(grid, start, end):

    visited = [start]
    queue = [start]

    while queue:
        first = queue.pop(0)
        allneighs = getNeighbors(first[0], first[1], grid)
        for item in allneighs:
            if item not in visited and grid[item[0]][item[1]] == 1:
                queue.append(item)
                visited.append(item)
            if grid[item[0]][item[1]] == "E":
                visited.append(end)
                return visited

    return -1


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


def GenerateMaze(grid):
    import random

    noOfObstacles = (len(grid) * len(grid[0])) // 2

    for _ in range(0, noOfObstacles):
        one = random.randint(0, len(grid) - 1)
        two = random.randint(0, len(grid[0]) - 1)
        if grid[one][two] == 1:
            grid[one][two] = "#"

    print(grid)


if __name__ == "__main__":
    grid = [
        [1, "S", 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, "E"],
    ]
    start = [0, 1]
    end = [4, 4]
    GenerateMaze(grid)
    print(BFSInGrid(grid, start, end))
