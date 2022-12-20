# By Iteration
def SpiralTraverse(matrix):
    l, r = 0, len(matrix[0])
    t, b = 0, len(matrix)
    ans = []

    while l < r and t < b:
        for i in range(l, r):
            ans.append(matrix[t][i])
        t = t + 1
        for i in range(t, b):
            ans.append(matrix[i][r - 1])
        r = r - 1
        if not (l < r) and (t < b):
            break
        for i in range(r - 1, l - 1, -1):
            ans.append(matrix[b - 1][i])
        b = b - 1
        for i in range(b - 1, t - 1, -1):
            ans.append(matrix[i][l])
        l = l + 1

    return ans


if __name__ == "__main__":
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    x = SpiralTraverse(matrix)
    print(x)
