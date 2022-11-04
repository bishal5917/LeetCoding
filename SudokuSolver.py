def SudokuSolver(board):
    return checkHorizontally(board, 0, 2, 5), checkVertically(board, 2, 0, 5)


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
