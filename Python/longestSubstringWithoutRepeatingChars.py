def lengthOfLongestSubstring(s):

    l = 0
    r = 0
    length = 0
    seenSet = set()

    while l < len(s) and r < len(s):
        if s[r] not in seenSet:
            seenSet.add(s[r])
            r += 1
        else:
            seenSet.remove(s[l])
            l += 1

        length = max(length, r - l)

    return length


if __name__ == "__main__":
    s = "abcabcbb"
    s = "bbbbb"
    s = "pwwkew"
    print(lengthOfLongestSubstring(s))
