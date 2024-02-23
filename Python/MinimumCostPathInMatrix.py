
def MinCost(matrix, i, j):
    n = len(matrix)
    m = len(matrix[0])

    if i == n-1 and j == m-1:
        return matrix[i][j]
    elif i == n-1:
        return matrix[i][j]+MinCost(matrix, i, j+1)
    elif j == m-1:
        return matrix[i][j]+MinCost(matrix, i+1, j)
    else:
        return matrix[i][j]+min(MinCost(matrix, i+1, j),MinCost(matrix, i, j+1))


matrix = [[3, 1, 7, 5],
          [6, 8, 4, 2]]

print(MinCost(matrix, 0, 0))
