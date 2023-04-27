def lengthOfLastWord(s):
    count = 0
    i = len(s) - 1
    if s[i] == " ":
        while s[i] == " ":
            i = i - 1

    while i >= 0:
        if s[i] == " ":
            return count
        count += 1
        i -= 1
    return count


if __name__ == "__main__":
    s = "Luffy is still joyboy  "
    print(lengthOfLastWord(s))
