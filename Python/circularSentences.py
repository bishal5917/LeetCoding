def isCircular(sentence):
    sens = sentence.split(" ")
    i, j = 0, 1

    while i < len(sens) - 1 and j < len(sens):
        firstLen = len(sens[i])
        if sens[i][firstLen - 1] == sens[j][0]:
            i += 1
            j += 1
        else:
            return False

    lastVal = len(sens[len(sens) - 1])
    if sens[0][0] == sens[len(sens) - 1][lastVal - 1]:
        return True
    return False


if __name__ == "__main__":
    sen = "leetcode exercises sound delightful"
    print(isCircular(sen))
