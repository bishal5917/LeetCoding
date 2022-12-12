def isAnagram(s, t):
    hash1 = {}
    hash2 = {}

    for item in s:
        if item not in hash1:
            hash1[item] = 1
        else:
            hash1[item] += 1

    for item in t:
        if item not in hash2:
            hash2[item] = 1
        else:
            hash2[item] += 1

    return hash1 == hash2


if __name__ == "__main__":
    s = "anagram"
    t = "nagaram"
    print(isAnagram(s, t))
