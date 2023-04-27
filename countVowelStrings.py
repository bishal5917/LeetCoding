def countVowelStrings(words, left, right):
    answerCount = 0
    vowels = ["a", "e", "i", "o", "u"]

    for i in range(left, right + 1):
        start, end = 0, len(words[i]) - 1
        if words[i][start] in vowels and words[i][end] in vowels:
            answerCount += 1

    return answerCount


if __name__ == "__main__":
    words = ["are", "amy", "u"]
    left = 0
    right = 2
    print(countVowelStrings(words, left, right))
