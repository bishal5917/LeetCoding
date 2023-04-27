def longestCommonPrefix(strs):
    
    for i in range(len(strs)):
        for item in strs[i]:
            print(item)



if __name__ == "__main__":
    strs = ["flower", "flow", "flight"]
    print(longestCommonPrefix(strs))
