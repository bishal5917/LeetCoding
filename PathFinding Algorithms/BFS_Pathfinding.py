def BFSInGrid(grid, start, end):

    visited = [start]
    queue = [start]
    prev = [start]

    while queue:
        first = queue.pop(0)
        allneighs = getNeighbors(first[0], first[1], grid)
        for item in allneighs:
            if item not in visited and grid[item[0]][item[1]] == 1:
                queue.append(item)
                visited.append(item)
                prev.append(first)
            if grid[item[0]][item[1]] == "E":
                visited.append(end)
                prev.append(first)

    # Getting the shortest path
    shortestPath = []
    shortestPath.append(visited[-1])
    shortestPath.append(prev[-1])
    while True:
        lastOne = shortestPath[-1]
        idx = visited.index(lastOne)
        shortestPath.append(prev[idx])
        if lastOne == start:
            shortestPath.pop()
            if shortestPath[0] != end:
                return False
            return shortestPath


def MakePath(grid, path):
    for item in path:
        if grid[item[0]][item[1]] == 1:
            grid[item[0]][item[1]] = "-"


def printMatrix(matrix):
    for item in matrix:
        for element in item:
            print(element, end="\t")
        print("")


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

    noOfObstacles = (len(grid) * len(grid[0])) // 3

    for _ in range(0, noOfObstacles):
        one = random.randint(0, len(grid) - 1)
        two = random.randint(0, len(grid[0]) - 1)
        if grid[one][two] == 1:
            grid[one][two] = "#"


if __name__ == "__main__":
    grid = [
        [1, "S", 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, 1],
        [1, 1, 1, 1, "E"],
    ]
    start = [0, 1]
    end = [6, 4]
    # testGridA = [
    #     [1, "S", 1, 1, 1],
    #     [1, "#", "#", "#", 1],
    #     [1, 1, 1, 1, 1],
    #     ["#", 1, "#", "#", "#"],
    #     [1, 1, 1, "E", 1],
    # ]
    # start = [0, 1]
    # end = [4, 3]
    # testGridB = [
    #     [1, "S", 1, 1, 1],
    #     ["#", 1, 1, "#", "#"],
    #     ["#", 1, "#", "#", 1],
    #     [1, 1, 1, 1, 1],
    #     ["#", "#", "#", "#", "E"],
    # ]
    # start = [0, 1]
    # end = [4, 4]
    GenerateMaze(grid)
    printMatrix(grid)
    print("")
    pathPlots = BFSInGrid(grid, start, end)
    if pathPlots != False:
        MakePath(grid, pathPlots)
        printMatrix(grid)
    else:
        print("No Path Found")
