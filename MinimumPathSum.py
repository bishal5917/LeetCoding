def minPathSum(grid):
    final = [[0 for i in range(0, len(grid[0]))] for j in range(0, len(grid))]

    for gidx in range(len(grid) - 1, -1, -1):
        for i in range(len(grid[gidx]) - 1, -1, -1):
            if gidx + 1 >= len(grid) and i + 1 >= len(grid[gidx]):
                final[gidx][i] = grid[gidx][i]
            if gidx + 1 >= len(grid) and i + 1 < len(grid[gidx]):
                final[gidx][i] = grid[gidx][i] + final[gidx][i + 1]
            if gidx + 1 < len(grid) and i + 1 >= len(grid[gidx]):
                final[gidx][i] = final[gidx + 1][i] + grid[gidx][i]
            # REPLACE MIN WITH MAX TO FIND MAXIMUM PATH SUM
            if gidx + 1 < len(grid) and i + 1 < len(grid[gidx]):
                final[gidx][i] = min(
                    grid[gidx][i] + final[gidx][i + 1],
                    grid[gidx][i] + final[gidx + 1][i],
                )

    return final[0][0]


if __name__ == "__main__":
    grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    grid = [[1, 2, 3], [4, 5, 6]]
    print(minPathSum(grid))
