def checkPalindrome(s):

    newStr = ""

    for item in s:
        if item.isalnum():
            newStr += item.lower()

    i, j = 0, len(newStr) - 1

    while i < j:
        if newStr[i] != newStr[j]:
            return False
        i += 1
        j -= 1

    return True


if __name__ == "__main__":
    s = "A man, a plan, a canal: Panama"
    # s = "amanaplanacanalpanama"
    print(checkPalindrome(s))
