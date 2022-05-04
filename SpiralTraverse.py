# By Iteration
def SpiralTraverse(arr):
    sr = 0
    sc = 0
    er = len(arr)-1
    ec = len(arr[0])-1
    ans = []

    while sr < er or sc < ec:
        for i in range(sc, ec+1):
            ans.append(arr[sr][i])
        for i in range(sr+1, er+1):
            ans.append(arr[i][ec])
        for i in reversed(range(sc, ec)):
            ans.append(arr[er][i])
        for i in reversed(range(sr+1, er)):
            ans.append(arr[i][sr])
        sr = sr+1
        sc = sc+1
        er = er-1
        ec = ec-1

    return ans


if __name__ == "__main__":
    givenArray = [[1, 2, 3, 4],
                  [12, 13, 14, 5],
                  [11, 16, 15, 6],
                  [10, 9, 8, 7]]
    x = SpiralTraverse(givenArray)
    print(x)


# By Recursion
def Spiral(arr):
    ans = []
    SpiralTraverse(arr, 0, 0, len(arr)-1, len(arr[0])-1, ans)
    return ans


def SpiralTraverse(arr, sr, sc, er, ec, ans):
    if sr > er and sc > ec:
        return
    for i in range(sc, ec+1):
        ans.append(arr[sr][i])
    for i in range(sr+1, er+1):
        ans.append(arr[i][ec])
    for i in reversed(range(sc, ec)):
        ans.append(arr[er][i])
    for i in reversed(range(sr+1, er)):
        ans.append(arr[i][sr])
    SpiralTraverse(arr, sr+1, sc+1, er-1, ec-1, ans)


if __name__ == "__main__":
    arr = [[1, 2, 3, 4],
           [12, 13, 14, 5],
           [11, 16, 15, 6],
           [10, 9, 8, 7]]
    x = Spiral(arr)
    print(x)