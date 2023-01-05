class Node:
    def __init__(self, row, col, value):
        self.id = str(row) + "-" + str(col)
        self.row = row
        self.col = col
        self.value = value
        self.g_score = float("inf")
        self.f_score = float("inf")
        self.previous = None


def aStarAlgo(startRow, startCol, endRow, endCol, graph):
    nodes = initializeNodes(graph)
    # print(nodes[1][1].value)
    startNode = nodes[startRow][startCol]
    endNode = nodes[endRow][endCol]
    startNode.g_score = 0
    startNode.f_score = startNode.g_score + calculateHeuristic(startNode, endNode)
    # print(startNode.f_score)

    # Now getting the MinHeap


def calculateHeuristic(startNode, endNode):
    # Here we are using Manhattan Distance for calculating heuristic
    a = startNode.row
    b = startNode.col
    c = endNode.row
    d = endNode.col
    dist = abs(c - a) + abs(d - b)
    return dist


# A function to initialize nodes of a graph with more details needed --
# -- as in class Node
def initializeNodes(graph):
    nodes = []

    for i, row in enumerate(graph):
        nodes.append([])
        for j, value in enumerate(row):
            nodes[i].append(Node(i, j, value))

    return nodes


if __name__ == "__main__":
    grid = [
        [1, "S", 1, 1, 1],
        [1, "#", "#", "#", 1],
        [1, 1, 1, 1, 1],
        ["#", 1, "#", "#", "#"],
        [1, 1, 1, "E", 1],
    ]
    startRow = 0
    startCol = 1
    endRow = 4
    endCol = 3
    aStarAlgo(startRow, startCol, endRow, endCol, grid)
