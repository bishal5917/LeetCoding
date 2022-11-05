def SudokuSolver(board):
    if solvePartialSudoku(board, 0, 0):
        return board
    else:
        return "Cant Solve"


def solvePartialSudoku(board, row, col):
    currentRow = row
    currentCol = col

    if currentCol == len(board[0]) - 1:
        currentRow += 1
        currentCol = 0
        if currentRow == len(board):
            return True
            # that means we have solved till the last one,so returns true

    if board[currentRow][currentCol] == 0:
        return TryPlacingDigits(board, currentRow, currentCol)

    return solvePartialSudoku(board, currentRow, currentCol + 1)


def TryPlacingDigits(board, Row, Col):
    for i in range(1, 10):
        if (
            checkHorizontally(board, Row, Col, i)
            and checkVertically(board, Row, Col, i)
            and checkSubGrid(board, Row, Col, i)
        ):
            board[Row][Col] = i
        if solvePartialSudoku(board, Row, Col + 1):
            return True

    board[Row][Col] = 0
    return False


# 3 checker functions
def checkHorizontally(board, i, j, num):
    # if return boolean is true we can place that element
    for item in board[i]:
        if item == num:
            return False
    return True


def checkVertically(board, i, j, num):
    # if return boolean is true we can place that element
    for items in board:
        if items[i] == num:
            return False
    return True


def checkSubGrid(board, i, j, num):
    # if return boolean is true we can place that element
    subgridRowStart = i // 3
    subgridColStart = j // 3
    for rowidx in range(3):
        for colidx in range(3):
            rowToCheck = subgridRowStart * 3 + rowidx
            colToCheck = subgridColStart * 3 + colidx
            currVal = board[rowToCheck][colToCheck]
            if num == currVal:
                return False
    return True


if __name__ == "__main__":
    board = [
        [7, 8, 0, 4, 0, 0, 1, 2, 0],
        [6, 0, 0, 0, 7, 5, 0, 0, 9],
        [0, 0, 0, 6, 0, 1, 0, 7, 8],
        [0, 0, 7, 0, 4, 0, 2, 6, 0],
        [0, 0, 1, 0, 5, 0, 9, 3, 0],
        [9, 0, 4, 0, 6, 0, 0, 0, 5],
        [0, 7, 0, 3, 0, 0, 0, 1, 2],
        [1, 2, 0, 0, 0, 7, 4, 0, 0],
        [0, 4, 9, 2, 0, 6, 0, 0, 7],
    ]
    print(SudokuSolver(board))
