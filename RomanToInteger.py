def romanToInt(s):
    maps = {"a": 0, "I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}

    s = s + "a"
    sum = 0
    i = 0
    while i < len(s) - 1:
        if s[i] == "I" and s[i + 1] == "V":
            sum = sum + 4
            i += 2
        elif s[i] == "I" and s[i + 1] == "X":
            sum = sum + 9
            i += 2
        elif s[i] == "X" and s[i + 1] == "L":
            sum = sum + 40
            i += 2
        elif s[i] == "X" and s[i + 1] == "C":
            sum = sum + 90
            i += 2
        elif s[i] == "C" and s[i + 1] == "D":
            sum = sum + 400
            i += 2
        elif s[i] == "C" and s[i + 1] == "M":
            sum = sum + 900
            i += 2
        else:
            roman = s[i]
            sum = sum + maps[roman]
            i += 1

    return sum


if __name__ == "__main__":
    s = "III"
    s = "MCMXCIV"
    print(romanToInt(s))
