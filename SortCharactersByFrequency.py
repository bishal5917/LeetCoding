def SortCharactersByFrequency(s):
    sortedOp = ""
    itemCount = {}
    for item in s:
        if item in itemCount:
            itemCount[item] += 1
        else:
            itemCount[item] = 1

    for word in itemCount:
        currCt = 0
        if len(sortedOp) == 0:
            while itemCount[word] != currCt:
                sortedOp += word
                currCt += 1
        if len(sortedOp) > 0:
            if itemCount[word] >= itemCount[sortedOp[-1]]:
                while itemCount[word] != currCt:
                    sortedOp = word + sortedOp
                    currCt += 1
            if itemCount[word] < itemCount[sortedOp[-1]]:
                while itemCount[word] != currCt:
                    sortedOp += word
                    currCt += 1
    return sortedOp


if __name__ == "__main__":
    s = "tree"
    print(SortCharactersByFrequency(s))
