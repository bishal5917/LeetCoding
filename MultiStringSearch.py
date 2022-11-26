# O(N^2) time and O(N) space
def MultiStringSearch(str, strs):
    foundarr = [False for _ in strs]

    for x in range(0, len(strs)):
        i = 0
        j = 0
        item = strs[x]
        while i < len(str) and j < len(item):
            if str[i] == item[j]:
                i += 1
                j += 1
            else:
                i += 1
        foundarr[x] = True if j == len(item) else False

    return foundarr


if __name__ == "__main__":
    stringToSearchIn = "this is a big string"
    stringsToSearch = ["this", "yo", "is", "a", "bigger", "string", "kappa"]
    print(MultiStringSearch(stringToSearchIn, stringsToSearch))
