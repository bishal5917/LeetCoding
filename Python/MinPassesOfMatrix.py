def MinPasses(matx):
    nextqueue = getAllPositivePositions(matx)
    passes = 0

    while len(nextqueue) > 0:
        currqueue = nextqueue
        nextqueue = []

        while len(currqueue) > 0:
            currRow, currCol = currqueue.pop(0)
            adjacentPos = getAdjacentPositions(currRow, currCol, matx)
            for position in adjacentPos:
                row, col = position
                value = matx[row][col]
                if value < 0:
                    matx[row][col] = value*-1
                    nextqueue.append([row, col])

        passes += 1

    return passes if not containsNegative(matx) else -1


def getAllPositivePositions(matx):
    positivePositions = []
    for row in range(len(matx)):
        for col in range(len(matx[0])):
            value = matx[row][col]
            if value > 0:
                positivePositions.append([row, col])

    return positivePositions


def getAdjacentPositions(currRow, currCol, matx):
    adjacentPositions = []
    if currRow > 0:
        adjacentPositions.append([currRow-1, currCol])
    if currCol > 0:
        adjacentPositions.append([currRow, currCol-1])
    if currRow < len(matx)-1:
        adjacentPositions.append([currRow+1, currCol])
    if currCol < len(matx[0])-1:
        adjacentPositions.append([currRow, currCol+1])

    return adjacentPositions


def containsNegative(matx):
    for row in matx:
        for item in row:
            if item < 0:
                return True
    return False


if __name__ == "__main__":
    matx = [[0, -1, 3, 2, 0], [1, -2, -5, 1, -3], [3, 0, 0, -4, -1]]
    x = MinPasses(matx)
    print(x)
