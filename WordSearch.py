class Solution(object):
    def exist(self, board, word):
        rows, cols = len(board), len(board[0])
        visited = []

        def DFS(r, c, i):
            if i == len(word):
                return True
            if (
                r < 0
                or c < 0
                or r >= rows
                or c >= cols
                or word[i] != board[r][c]
                or [r, c] in visited
            ):
                return False
            visited.append([r, c])
            if DFS(r + 1, c, i + 1):
                return True
            if DFS(r - 1, c, i + 1):
                return True
            if DFS(r, c + 1, i + 1):
                return True
            if DFS(r, c - 1, i + 1):
                return True
            visited.remove([r, c])
            return False

        for i in range(rows):
            for j in range(cols):
                if DFS(i, j, 0):
                    return True

        return False


board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
# word = "ABCCED"
word = "ADEE"
obj = Solution()
print(obj.exist(board, word))
