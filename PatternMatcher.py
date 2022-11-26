def PatternMatcher(pattern, str):
    patternarr = []
    for item in pattern:
        patternarr.append(item)

    # getting first index of y
    for i in range(0, len(pattern)):
        if pattern[i] == "y":
            firstYIdx = i
            break

    # count x and y
    countHash = {}
    for item in pattern:
        if item in countHash:
            countHash[item] += 1
        else:
            countHash[item] = 1

    # main part starts here

    lenOfX = 1
    while lenOfX != len(str):
        # we will keep increasing lenOfX till pattern matches
        lenOfY = (len(str) - lenOfX * countHash["x"]) // countHash["y"]
        ystartingIdx = firstYIdx * lenOfX
        potentialX = str[0:lenOfX]
        potentialY = str[ystartingIdx : lenOfY + ystartingIdx]
        potentialString = ""
        for item in pattern:
            if item == "x":
                potentialString = potentialString + potentialX
            if item == "y":
                potentialString = potentialString + potentialY

        lenOfX += 1

        if potentialString == str:
            return True
        else:
            continue

    return False


if __name__ == "__main__":
    pattern = "xxyxxy"
    str = "gogopowerrangergogopowerranger"
    print(PatternMatcher(pattern, str))
