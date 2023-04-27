def findTheLongestBalancedSubstring(s):
    currMaxLength = 0

    for i in range(0, len(s)):
        l, r = i, i
        while l >= 0 and r <= len(s) - 1 and s[l] == "0" and s[r] == "1":
            if (r - l + 1) > currMaxLength:
                currMaxLength = r - l + 1
            l -= 1
            r += 1

        l, r = i, i + 1
        while l >= 0 and r <= len(s) - 1 and s[l] == "0" and s[r] == "1":
            if (r - l + 1) > currMaxLength:
                currMaxLength = r - l + 1
            l -= 1
            r += 1

    return currMaxLength


if __name__ == "__main__":
    s = "01000111"
    print(findTheLongestBalancedSubstring(s))
