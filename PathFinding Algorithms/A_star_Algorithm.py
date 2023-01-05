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
    print(nodes[1][1].value)


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
