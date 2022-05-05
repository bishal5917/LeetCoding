# Space complexity = O(c) where c=total letters stored in hash table
# Time complexity = O(n*l)
# where ; n= total words in given array
#         l= total letters in a word
# This is because we had to go for every letters in every word
#Note : c<=l
def MinCharForWords(arr):
    unique = []
    finalHash = {}
    currentHash = {}
    for item in arr:
        for letter in item:
            if letter in currentHash:
                currentHash[letter] += 1
            else:
                currentHash[letter] = 1
        for item in currentHash:
            if item not in finalHash:
                finalHash[item] = currentHash[item]
            if item in finalHash:
                finalHash[item] = max(currentHash[item], finalHash[item])

        currentHash = {}

    for item in finalHash:
        for i in range(finalHash[item]):
            unique.append(item)

    return unique

if __name__ == "__main__":
    ArrOfStr = ["this", "that", "did", "deed", "them!", "a"]
    x = MinCharForWords(ArrOfStr)
    print(x)
