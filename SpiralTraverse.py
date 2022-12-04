# By Iteration
def SpiralTraverse(matrix):
    sr = 0
    sc = 0
    er = len(matrix)-1
    ec = len(matrix[0])-1
    ans = []

    while sr < er or sc < ec:
        for i in range(sc, ec+1):
            ans.append(matrix[sr][i])
        for i in range(sr+1, er+1):
            ans.append(matrix[i][ec])
        for i in reversed(range(sc, ec)):
            ans.append(matrix[er][i])
        for i in reversed(range(sr+1, er)):
            ans.append(matrix[i][sr])
        sr = sr+1
        sc = sc+1
        er = er-1
        ec = ec-1

    return ans


if __name__ == "__main__":
    givenmatrixay = [[1,2,3],[4,5,6],[7,8,9]]
    x = SpiralTraverse(givenmatrixay)
    print(x)


# By Recursion
def Spiral(matrix):
    ans = []
    SpiralTraverse(matrix, 0, 0, len(matrix)-1, len(matrix[0])-1, ans)
    return ans


def SpiralTraverse(matrix, sr, sc, er, ec, ans):
    if sr > er and sc > ec:
        return
    for i in range(sc, ec+1):
        ans.append(matrix[sr][i])
    for i in range(sr+1, er+1):
        ans.append(matrix[i][ec])
    for i in reversed(range(sc, ec)):
        ans.append(matrix[er][i])
    for i in reversed(range(sr+1, er)):
        ans.append(matrix[i][sr])
    SpiralTraverse(matrix, sr+1, sc+1, er-1, ec-1, ans)


if __name__ == "__main__":
    matrix = [[1, 2, 3, 4],
           [12, 13, 14, 5],
           [11, 16, 15, 6],
           [10, 9, 8, 7]]
    x = Spiral(matrix)
    print(x)