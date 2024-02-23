def PatternMatcher(pattern, str):
    patternarr = []
    # we are making sure that the pattern starts with "x" coz Algorithm is made thiswise
    if pattern[0] == "x":
        for item in pattern:
            patternarr.append(item)
    elif pattern[0] == "y":
        for item in pattern:
            if item == "y":
                patternarr.append("x")
            elif item == "x":
                patternarr.append("y")
    # return patternarr

    # getting first index of y
    for i in range(0, len(patternarr)):
        if patternarr[i] == "y":
            firstYIdx = i
            break

    # count x and y
    countHash = {}
    for item in patternarr:
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
        for item in patternarr:
            if item == "x":
                potentialString = potentialString + potentialX
            if item == "y":
                potentialString = potentialString + potentialY

        lenOfX += 1

        if potentialString == str:
            return potentialX, potentialY
        else:
            continue

    return False


if __name__ == "__main__":
    pattern = "xxyxxy"
    str = "gogopowerrangergogopowerranger"
    # pattern = "xxy"
    # str = "gogopower"
    print(PatternMatcher(pattern, str))
