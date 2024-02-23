def UniquePaths(m, n):
    final = [[0 for i in range(0, n)] for j in range(0, m)]
    final[m - 1][n - 1] = 1

    for idx in range(m - 1, -1, -1):
        for num in range(n - 1, -1, -1):
            if num + 1 < n and idx + 1 >= m:
                final[idx][num] = final[idx][num + 1]
            if idx + 1 < m and num + 1 >= n:
                final[idx][num] = final[idx + 1][num]
            if idx + 1 < m and num + 1 < n:
                final[idx][num] = final[idx + 1][num] + final[idx][num + 1]

    return final[0][0]


if __name__ == "__main__":
    rows = 3
    cols = 7
    print(UniquePaths(rows, cols))
