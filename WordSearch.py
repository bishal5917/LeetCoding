def WordSearch(board, word):
    idx = getIdxOfFirstLetter(board, word)
    fidx = idx[0]
    # for i in range(1, len(word)):
    wordLocs = [idx[0]]
    
    i = 0
    neighbs = getNeighbors(fidx[0], fidx[1], board)

    while i < len(word):
        # return neighbs
        for item in neighbs:
            if board[item[0]][item[1]] == word[i]:
                # print(i)
                wordLocs.append([item[0], item[1]])
                neighbs = getNeighbors(item[0], item[1], board)
                print(neighbs)
            else:
                continue
        i += 1
    return wordLocs, len(wordLocs) == len(word)


def getIdxOfFirstLetter(board, word):
    idxs = []
    firstLetter = word[0]
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == firstLetter:
                idxs.append([i, j])
    return idxs


def getNeighbors(row, col, board):
    neighbors = []
    if (col + 1) < len(board[0]):
        neighbors.append([row, col + 1])
    if (col - 1) >= 0:
        neighbors.append([row, col - 1])
    if (row - 1) >= 0:
        neighbors.append([row - 1, col])
    if (row + 1) < len(board):
        neighbors.append([row + 1, col])

    return neighbors


if __name__ == "__main__":
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    # word = "ABCCED"
    word = "ADEE"
    print(WordSearch(board, word))
    # print(getNeighbors(0, 1, board))
