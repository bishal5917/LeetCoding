def RotateImage(matrix):
    for i in range(len(matrix[0])):
        for j in range(i, len(matrix[0])):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]

    for i in range(len(matrix[0])):
        matrix[i].reverse()

    return matrix


if __name__ == "__main__":
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(RotateImage(matrix))
