def WordSearch(board, word):
    idxs = getIdxOfFirstLetter(board, word)

    for item in idxs:
        wordLocs = [item]

        i = 0
        neighbs = getNeighbors(item[0], item[1], board)

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

        if len(wordLocs) == len(word):
            return wordLocs, True
        else:
            continue

    return False


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
    # board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    # word = "ABCCED"
    # word = "ADEE"
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCB"
    print(WordSearch(board, word))
