def IndexOfOccurence(needle, haystack):
    for i in range(0,len(haystack)):
        if needle[i]==haystack[i]:
            for j in range(i,i+len(needle)):
                if needle[i]==haystack[j]:
                    print(i)

if __name__ == "__main__":
    # haystack = "leetcode"
    # needle = "etc"
    haystack = "mississippi"
    needle = "issip"
    print(IndexOfOccurence(needle, haystack))
