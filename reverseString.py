def reverseString(s):
    first, last = 0, len(s) - 1

    while first < last:
        s[first], s[last] = s[last], s[first]
        first += 1
        last -= 1

    return s


if __name__ == "__main__":
    s = ["H", "a", "n", "n", "a", "h"]
    print(reverseString(s))
