def longestPalindrome(s):
    longestStr = ""
    currMaxLength = 0

    for i in range(0, len(s)):
        l, r = i, i
        while l >= 0 and r <= len(s) - 1 and s[l] == s[r]:
            if (r - l + 1) > currMaxLength:
                currMaxLength = r - l + 1
                longestStr = s[l : r + 1]
            l -= 1
            r += 1

        l, r = i, i + 1
        while l >= 0 and r <= len(s) - 1 and s[l] == s[r]:
            if (r - l + 1) > currMaxLength:
                currMaxLength = r - l + 1
                longestStr = s[l : r + 1]
            l -= 1
            r += 1
            
    return longestStr


if __name__ == "__main__":
    s = "babad"
    print(longestPalindrome(s))
