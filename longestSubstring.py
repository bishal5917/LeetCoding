def longestSubstring(s, k):
    currLongest = 0
    hash = {}

    for item in s:
        if item not in hash:
            hash[item] = 1
        else:
            hash[item] += 1

    for item in hash:
        if hash[item] >= k:
            currLongest += hash[item]
    return currLongest


if __name__ == "__main__":
    s = "aaabb"
    k = 3
    print(longestSubstring(s, k))
