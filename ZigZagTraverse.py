# Time Complexity = O(n)
# Space Complexity= O(n)


def ZigZagTraverse(arr):
    height = len(arr) - 1
    width = len(arr[0]) - 1
    row = 0
    col = 0
    goingDown = True
    ans = []

    while not isOutOfBounds(row, col, height, width):
        ans.append(arr[row][col])
        if goingDown:
            if col == 0 or row == height:
                goingDown = False
                if row == height:
                    col += 1
                else:
                    row += 1
            else:
                row += 1
                col -= 1
        else:
            if row == 0 or col == width:
                goingDown = True
                if col == width:
                    row += 1
                else:
                    col += 1
            else:
                row -= 1
                col += 1

    return ans


def isOutOfBounds(row, col, height, width):
    return row < 0 or row > width or col < 0 or col > height


if __name__ == "__main__":
    arr = [[1, 3, 4, 10], [2, 5, 9, 11], [6, 8, 12, 15], [7, 13, 14, 16]]
    print(ZigZagTraverse(arr))
