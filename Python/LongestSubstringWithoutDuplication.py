def LongestSubstring(str):
    startIdx = 0
    # keeping track of index of item when it was last seen
    lastSeenHash = {}
    # the starting and ending index of longest substring
    longest = [0, 1]
    for i, char in enumerate(str):
        if char in lastSeenHash:
            startIdx = max(startIdx, lastSeenHash[char]+1)
        if longest[1]-longest[0] < i+1-startIdx:
            longest = [startIdx, i+1]
        lastSeenHash[char] = i
    return str[longest[0]:longest[1]]


if __name__ == "__main__":
    str = "clementisacap"
    # required ans = mentisac
    x = LongestSubstring(str)
    print(x)
