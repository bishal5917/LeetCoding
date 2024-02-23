# FOR ABC:
# answer=asciiValueOf"C"*(26^2)+asciiValueOf"C"*(26^1)+asciiValueOf"C"*(26^0)


def titleToNumber(columnTitle):
    number = 0

    for i in reversed(range(len(columnTitle))):
        value = ord(columnTitle[i]) - ord("A") + 1
        power = abs(i - len(columnTitle) + 1)
        number += value * pow(26, power)

    return number


if __name__ == "__main__":
    ttle = "ZY"
    print(titleToNumber(ttle))
