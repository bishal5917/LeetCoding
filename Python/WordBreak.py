def WordBreak(s, wordDict):
    dp = [False] * (len(s) + 1)
    dp[len(s)] = True

    for i in range(len(s) - 1, -1, -1):
        for item in wordDict:
            if (i + len(item)) <= len(s) and s[i : i + len(item)] == item:
                dp[i] = dp[i + len(item)]

            if dp[i]:
                break

    return dp[0]


if __name__ == "__main__":
    s = "leetcode"
    wordDict = ["leet", "code"]
    print(WordBreak(s, wordDict))
