# A classic Graph Traversal Question
def RiverSizes(graph):
    visitedMatrix = [[False for i in range(len(graph))] for j in range(len(graph[0]))]
    riverSize = []
    for i in range(len(graph)):
        for j in range(len(graph[0])):
            if graph[i][j] == 1 and visitedMatrix[i][j] == False:
                visitedMatrix[i][j] = True
                currRiverSize = 1
                neighbours = getNeighbors(i, j, graph)
                if len(neighbours) == 0:
                    riverSize.append(currRiverSize)
                    continue
                while len(neighbours):
                    item = neighbours.pop()
                    a = item[0]
                    b = item[1]
                    if graph[a][b] == 0:
                        continue
                    elif graph[a][b] == 1 and visitedMatrix[a][b] == False:
                        visitedMatrix[a][b] = True
                        currRiverSize += 1
                        newNeighs = getNeighbors(a, b, graph)
                        neighbours.extend(newNeighs)
                    elif graph[a][b] == 1 and visitedMatrix[a][b] == True:
                        continue
                    riverSize.append(currRiverSize)

    return riverSize


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
    print(RiverSizes(graph))
