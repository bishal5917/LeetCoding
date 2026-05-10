class Solution(object):
    def minDistance(self, word1, word2):

        word1len = len(word1)
        word2len = len(word2)
    
        # Dynamic programming - Bottom up approach
        # Lets make a dp table
        dp = [[0] * (word2len + 1) for _ in range(word1len + 1)]
        # Assign with values on the last columns and row
        for i in range(word1len):
            dp[i][word2len] = word1len - i
        for i in range(word2len+1):
            dp[word1len][i] = word2len - i

        # Bottom Up Iteration

        for i in reversed(range(word1len)):
            for j in reversed(range(word2len)):
                # Now check and assign the required distance in a bottom up manner
                if word1[i] == word2[j]:
                    # just assign with that of lower diagonal
                    dp[i][j] = dp[i+1][j+1]
                else:
                    # calculate the minimum in three directions and assign with that by incrementing 1
                    dp[i][j] = min(dp[i+1][j+1], dp[i][j+1], dp[i+1][j]) + 1

        print(dp)
        return dp[0][0]
        
    def minDistanceBruteforce(self, word1, word2):
        # for each position (we either insert, delete, or update)
        # And calculate the minimum distance
        return self.minDistanceBruteforceRecursiveHelper(word1, word2, 0, 0)
                    
    def minDistanceBruteforceRecursiveHelper(self, word1, word2, i, j):
        # Base cases
        # If word1 exhausted
        if i == len(word1):
            return len(word2) - j

        # If word2 exhausted
        if j == len(word2):
            return len(word1) - i
        
        # Characters match
        if word1[i] == word2[j]:
            return self.minDistanceBruteforceRecursiveHelper(word1, word2, i+1, j+1)
        
        # Try all 3 operations
        insert_op = 1 + self.minDistanceBruteforceRecursiveHelper(word1,word2,i,j+1)
        delete_op = 1 + self.minDistanceBruteforceRecursiveHelper(word1,word2,i+1,j)
        replace_op = 1 + self.minDistanceBruteforceRecursiveHelper(word1,word2,i+1,j+1)

        return min(insert_op,delete_op,replace_op)

if __name__ == "__main__":
    sol = Solution()
    word1 = "horse"
    word2 = "ros"
    print(sol.minDistance(word1, word2))
    print(sol.minDistanceBruteforce(word1, word2))
