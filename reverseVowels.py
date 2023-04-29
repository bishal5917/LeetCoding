def reverseVowels(s):
    vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
    str = []
    for items in s:
        str.append(items)
    i, j = 0, len(s) - 1

    while i < j:
        if s[i] in vowels and s[j] in vowels:
            temp = str[i]
            str[i] = str[j]
            str[j] = temp
            i += 1
            j -= 1
        if s[i] in vowels and s[j] not in vowels:
            j -= 1
        if s[i] not in vowels and s[j] in vowels:
            i += 1
        if s[i] not in vowels and s[j] not in vowels:
            i += 1
            j -= 1

    return "".join(str)


if __name__ == "__main__":
    s = "leetcode"
    print(reverseVowels(s))
