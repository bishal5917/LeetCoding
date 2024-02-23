def SetMatrixZeroes(matrix):
    zeroesPos = getZeroesPos(matrix)
    # print(zeroesPos)

    for item in zeroesPos:
        # setting horizontally zeroes
        for i in range(len(matrix[0])):
            matrix[item[0]][i] = 0

        # setting vertically zeroes
        for i in range(len(matrix)):
            matrix[i][item[1]] = 0

    return matrix


def getZeroesPos(matrix):
    arr = []
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j] == 0:
                arr.append([i, j])

    return arr


if __name__ == "__main__":
    # matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
    matrix = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]
    print(SetMatrixZeroes(matrix))
