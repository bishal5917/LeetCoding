class Solution(object):
    def exist(self, board, word):
        idxs = self.getIdxOfFirstLetter(board, word)

        for item in idxs:
            wordLocs = [item]

            i = 0
            neighbs = self.getNeighbors(item[0], item[1], board)

            while i < len(word):
                for item in neighbs:
                    if (
                        board[item[0]][item[1]] == word[i]
                        and self.checkIfAlreadyVisited(wordLocs, item[0], item[1])
                        == False
                    ):
                        wordLocs.append([item[0], item[1]])
                        neighbs = self.getNeighbors(item[0], item[1], board)
                        # print(neighbs)
                    else:
                        continue
                i += 1

            if len(wordLocs) == len(word):
                # return wordLocs, True
                return True
            else:
                continue

        return wordLocs,False

    def getIdxOfFirstLetter(self, board, word):
        idxs = []
        firstLetter = word[0]
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == firstLetter:
                    idxs.append([i, j])
        return idxs

    def checkIfAlreadyVisited(self, visitedIdxs, row, col):
        for item in visitedIdxs:
            if item[0] == row and item[1] == col:
                return True
        return False

    def getNeighbors(self, row, col, board):
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


# board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
# word = "ABCCED"
# word = "ADEE"
board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
word = "SEE"
obj = Solution()
print(obj.exist(board, word))
